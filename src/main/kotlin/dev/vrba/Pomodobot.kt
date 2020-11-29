package dev.vrba

import dev.vrba.pomodobot.CommandDispatcher
import dev.vrba.pomodobot.database.Database
import net.dv8tion.jda.api.JDABuilder

fun main(args: Array<String>) {
    val token = args.firstOrNull() ?: throw IllegalArgumentException("""
            |Please provide a Discord bot token as the first parameter.
            |java -jar ./pomodobot.jar <DISCORD_TOKEN>
            |
            |To obtain a Discord bot token, create an app on https://discord.com/developers/applications
        """.trimMargin())

    val client = JDABuilder.createDefault(token)
    val dispatcher = CommandDispatcher()

    println(Database.sessions.queryForAll())

    client.addEventListeners(dispatcher)
}