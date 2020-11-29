package dev.vrba.pomodobot.database

import com.j256.ormlite.dao.Dao
import com.j256.ormlite.dao.DaoManager
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource
import com.j256.ormlite.table.TableUtils

object Database {
    private val connection = JdbcPooledConnectionSource("jdbc:h2:mem:pomodobot")

    init {
        TableUtils.createTableIfNotExists(connection, PomodoroSession::class.java)
    }

    val sessions: Dao<PomodoroSession, Long> = DaoManager.createDao(connection, PomodoroSession::class.java)
}