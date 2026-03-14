package xyz.thehiddenobject.thochat.common.infrastructure.database

import eu.okaeri.configs.OkaeriConfig

open class DatabaseConfiguration: OkaeriConfig() {
    var type: DatabaseType = DatabaseType.H2

    var host: String = "localhost"

    var port: Int = 3306

    var database: String = "thochat"

    var username: String = "root"

    var password: String = "password"

    var poolSize: Int = 5

    var connectionTimeout: Long = 30000

    var ssl: Boolean = false
}