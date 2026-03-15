package xyz.thehiddenobject.thochat.common.configuration

import eu.okaeri.configs.OkaeriConfig

class WebhookConfiguration: OkaeriConfig() {
    var enabled: Boolean = false

    var webhook: String = "webhook"

    var postActions = PostActions()
}

class PostActions: OkaeriConfig() {
    var chatOn: Boolean = true
    var chatOff: Boolean = true
    var chatPremium: Boolean = true
    var chatCleared: Boolean = true
}