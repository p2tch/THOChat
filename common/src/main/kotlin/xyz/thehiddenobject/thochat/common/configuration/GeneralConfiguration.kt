package xyz.thehiddenobject.thochat.common.configuration

import eu.okaeri.configs.OkaeriConfig
import eu.okaeri.configs.annotation.Comment
import xyz.thehiddenobject.thochat.common.infrastructure.database.DatabaseConfiguration

open class GeneralConfiguration : OkaeriConfig() {
    @Comment("Database configuration")
    var database: DatabaseConfiguration = DatabaseConfiguration()

    @Comment("Webhook configuration")
    var webhook: WebhookConfiguration = WebhookConfiguration()

    @Comment("Chat configuration")
    var chat: ChatConfiguration = ChatConfiguration()
}
