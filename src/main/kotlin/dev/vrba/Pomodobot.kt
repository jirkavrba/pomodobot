package dev.vrba

fun main(args: Array<String>) {
    val token = args.firstOrNull() ?:
        throw IllegalArgumentException("""
            |Please provide a Discord bot token as the first parameter.
            |java -jar ./pomodobot.jar <DISCORD_TOKEN>
            |
            |To obtain a Discord bot token, create an app on https://discord.com/developers/applications
        """.trimMargin())
}