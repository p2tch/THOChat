package xyz.thehiddenobject.thochat.common.module

import com.google.inject.AbstractModule
import eu.okaeri.configs.ConfigManager
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer
import xyz.thehiddenobject.thochat.common.configuration.GeneralConfiguration
import xyz.thehiddenobject.thochat.common.infrastructure.database.DatabaseConfiguration
import java.io.File
import kotlin.jvm.java

class ConfigurationModule(
    private val dataFolder: File
): AbstractModule() {
    override fun configure() {
        val file = File(dataFolder, "config.yml")

        val configuration = ConfigManager.create(GeneralConfiguration::class.java) {
            it.configure { opt ->
                opt.configurer(YamlSnakeYamlConfigurer())
                opt.bindFile(file)

                it.saveDefaults()
                it.load(true)
            }
        }

        bind(GeneralConfiguration::class.java).toInstance(configuration)
        bind(DatabaseConfiguration::class.java).toInstance(configuration.database)
    }
}