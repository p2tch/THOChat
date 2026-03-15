package xyz.thehiddenobject.thochat.common.infrastructure.database

import com.google.inject.Inject
import com.j256.ormlite.jdbc.DataSourceConnectionSource
import com.j256.ormlite.support.ConnectionSource
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import sun.jvm.hotspot.HelloWorld.e
import java.io.File

class DatabaseManager @Inject constructor(
    private val databaseConfiguration: DatabaseConfiguration
) {
    private lateinit var dataSource: HikariDataSource
    lateinit var connectionSource: ConnectionSource

    fun connect(dataFolder: File) {
        val hikariConfig = HikariConfig().apply {
            jdbcUrl = databaseConfiguration.toJdbcUrl(dataFolder)
            username = databaseConfiguration.username
            password = databaseConfiguration.password
            maximumPoolSize = databaseConfiguration.poolSize
            connectionTimeout = databaseConfiguration.connectionTimeout
            poolName = "THOChat-Pool"
        }

        dataSource = HikariDataSource(hikariConfig)

        connectionSource = DataSourceConnectionSource(dataSource, hikariConfig.jdbcUrl)
    }

    fun disconnect() {
        if (::connectionSource.isInitialized) {
            connectionSource.close()
        }

        if (::dataSource.isInitialized) {
            dataSource.close()
        }
    }
}
