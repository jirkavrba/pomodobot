package dev.vrba.pomodobot.wrappers

data class PomodoroSession(
    val ownerId: Long,
    val channelId: Long,
    val configuration: PomodoroConfiguration,
)
