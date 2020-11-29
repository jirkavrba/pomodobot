package dev.vrba.pomodobot.wrappers

data class PomodoroConfiguration(
    val pomodoroDuration: Int = 25 * 60,
    val shortBreakDuration: Int = 5 * 60,
    val longBreakDuration: Int = 15 * 60,
    val longBreakIterations: Int = 4,
)
