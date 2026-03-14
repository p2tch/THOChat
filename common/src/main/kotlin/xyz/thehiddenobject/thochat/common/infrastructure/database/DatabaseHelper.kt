package xyz.thehiddenobject.thochat.common.infrastructure.database

import java.io.File

fun DatabaseConfiguration.toJdbcUrl(dataFolder: File): String {
    return when (type) {
        DatabaseType.MYSQL -> "jdbc:mysql://$host:$port/$database?useSSL=$ssl&serverTimezone=UTC"
        DatabaseType.H2 -> "jdbc:h2:${dataFolder.absolutePath}/$database"
        DatabaseType.POSTGRESQL -> "jdbc:postgresql://$host:$port/$database?ssl=$ssl"
        DatabaseType.SQLITE -> "jdbc:sqlite:${dataFolder.absolutePath}/$database.db"
    }
}