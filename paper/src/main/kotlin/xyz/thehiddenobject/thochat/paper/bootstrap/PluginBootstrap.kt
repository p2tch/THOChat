package xyz.thehiddenobject.thochat.paper.bootstrap

import com.google.inject.Guice
import com.google.inject.Injector
import org.bukkit.plugin.java.JavaPlugin
import xyz.thehiddenobject.thochat.common.infrastructure.database.DatabaseManager
import xyz.thehiddenobject.thochat.common.module.ConfigurationModule
import xyz.thehiddenobject.thochat.paper.extension.slf4j

class PluginBootstrap: JavaPlugin() {
    lateinit var databaseManager: DatabaseManager
    lateinit var injector:        Injector
    private val logger by slf4j()

    override fun onLoad() {
        injector = Guice.createInjector(
            ConfigurationModule(dataFolder)
        )

        databaseManager = injector.getInstance(DatabaseManager::class.java)
        databaseManager.connect(dataFolder)
    }

    override fun onEnable() {

    }

    override fun onDisable() {
        databaseManager.disconnect()
    }
}