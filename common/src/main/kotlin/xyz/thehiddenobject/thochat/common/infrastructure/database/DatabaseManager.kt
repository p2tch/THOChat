package xyz.thehiddenobject.thochat.common.infrastructure.database

import com.google.inject.Inject
import com.j256.ormlite.jdbc.DataSourceConnectionSource
import com.j256.ormlite.support.ConnectionSource
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import java.io.File

class DatabaseManager @Inject constructor(
    private val databaseConfiguration: DatabaseConfiguration
) {
    private val dataSource: HikariDataSource by lazy { HikariDataSource() }
    lateinit var connectionSource: ConnectionSource

    fun connect(dataFolder: File) {
        try {
            val hikariConfig = HikariConfig().apply {
                jdbcUrl = databaseConfiguration.toJdbcUrl(dataFolder)
                username = databaseConfiguration.username
                password = databaseConfiguration.password
                maximumPoolSize = databaseConfiguration.poolSize
                connectionTimeout = databaseConfiguration.connectionTimeout
                poolName = "THOChat-Pool"
            }

            dataSource.apply {
                this.maximumPoolSize = hikariConfig.maximumPoolSize
                this.connectionTimeout = hikariConfig.connectionTimeout
                this.jdbcUrl = hikariConfig.jdbcUrl
                this.username = hikariConfig.username
                this.password = hikariConfig.password
                this.poolName = hikariConfig.poolName
            }

            connectionSource = DataSourceConnectionSource(dataSource, hikariConfig.jdbcUrl)
        } catch (e: Exception) {
            println("Failed to connect to database or create tables: ${e.message}")
            e.printStackTrace()
        }
    }

    fun disconnect() {
        try {
            if (::connectionSource.isInitialized) {
                connectionSource.close()
            }
        } catch (e: Exception) {
            println("Failed to close connection source: ${e.message}")
            e.printStackTrace()
        } finally {
            dataSource.close()
        }
    }
}
