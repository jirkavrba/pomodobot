package dev.vrba.pomodobot

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter


class CommandDispatcher : ListenerAdapter() {
    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        val content = event.message.contentRaw.trim()
        val parts = content.split(" ")

        val command = parts.first()
        val arguments = parts.drop(1)

        if (!command.startsWith("+") || event.author.isBot) return

        when (command) {
            "+pomodoro" -> println("Pomodoro command triggered")
            "+stop" -> println("Stop command triggered")
        }
    }
}