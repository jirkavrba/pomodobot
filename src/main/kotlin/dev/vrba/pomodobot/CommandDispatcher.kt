package dev.vrba.pomodobot

import dev.vrba.pomodobot.commands.StartPomodoroCommand
import dev.vrba.pomodobot.exceptions.CommandExecutionException
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter


class CommandDispatcher : ListenerAdapter() {
    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        val content = event.message.contentRaw.trim()
        val parts = content.split(" ")

        val name = parts.first().toLowerCase()
        val arguments = parts.drop(1)

        if (!name.startsWith("+") || event.author.isBot) return

        val command = when (name) {
            "+pstart" -> StartPomodoroCommand()
//            "+ppause" ->
//            "+pstop" ->
            else -> return
        }

        try {
            command.execute(arguments, event)
        } catch (exception: CommandExecutionException) {
            sendErrorEmbed(exception, event)
        }
    }

    private fun sendErrorEmbed(exception: CommandExecutionException, event: GuildMessageReceivedEvent) {
        event.channel
            .sendMessage(
                EmbedBuilder()
                    .setColor(EmbedColor.Red)
                    .setTitle("Ooopsie")
                    .setFooter(event.member?.nickname ?: event.author.asTag, event.author.avatarUrl)
                    .setDescription(exception.message)
                    .setTimestamp(event.message.timeCreated)
                    .build()
            ).queue()
    }
}