package xyz.thehiddenobject.thochat.common.configuration

import eu.okaeri.configs.OkaeriConfig
import eu.okaeri.configs.annotation.Comment

class ChatConfiguration: OkaeriConfig() {
    var cooldown: Int = 5

    @Comment("Available placeholders to use:")
    @Comment("{PREFIX} - returns player's prefix")
    @Comment("{PLAYER_NAME} - returns player's name")
    @Comment("{SUFFIX} - returns player's suffix")
    @Comment("{WORLD} - returns player's world")
    @Comment("{MESSAGE} - returns player's message")
    @Comment("{PING} - returns player's ping")
    var messageFormat: String = "{PREFIX} {PLAYER_NAME}: {MESSAGE}"

    @Comment("WARNING: Allowing players to use MiniMessage interactive tags (<click>, <hover>, etc.) is potentially dangerous!")
    @Comment("It may allow players to execute commands, click links, or trigger unexpected behavior.")
    @Comment("Not recommended to enable unless you fully trust your players.")
    var allowInteractiveTags: Boolean = false

    @Comment("What should happen when a player uses blocked interactive tags?")
    @Comment("Options: none - silently remove, warn - send a warning, cancel_message - reject the message entirely")
    var blockedTagAction: String = "cancel_message"
}
