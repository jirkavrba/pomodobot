package dev.vrba.pomodobot.commands

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

interface Command {
    fun execute(arguments: List<String>, event: GuildMessageReceivedEvent)
}