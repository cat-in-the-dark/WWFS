package org.catinthedark.gban.game.components

import com.artemis.Component

class PlayerStateComponent(
    var crawling: Boolean = false,
    var moving: Boolean = false
): Component()
