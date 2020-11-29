package dev.vrba.pomodobot.commands

import dev.vrba.pomodobot.exceptions.CommandExecutionException
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

class StartPomodoroCommand : Command {
    override fun execute(arguments: List<String>, event: GuildMessageReceivedEvent) {
        throw CommandExecutionException("Sugma")
    }
}