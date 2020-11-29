package dev.vrba.pomodobot.database

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable

@DatabaseTable(tableName="pomodoro_sessions")
data class PomodoroSession(
    @DatabaseField(generatedId = true)
    val id: Long,
    @DatabaseField
    val ownerId: Long,
    @DatabaseField
    val channelId: Long,

    @DatabaseField
    val pomodoroDuration: Int = 25 * 60,
    @DatabaseField
    val shortBreakDuration: Int = 5 * 60,
    @DatabaseField
    val longBreakDuration: Int = 15 * 60,
    @DatabaseField
    val longBreakIterations: Int = 4,
) {
    // This constructor is required due to the ORM implementation
    @Suppress("unused")
    constructor() : this(0, 0, 0)
}