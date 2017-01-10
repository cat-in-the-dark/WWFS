package org.catinthedark.gban.game.components

import com.artemis.Component

class ParallaxComponent(
    var distance: Float = 0f,
    val isDistant: Boolean = false,
    var currentAngle: Float = 0f,
    var direction: Float = -1f,
    val minAngle: Float = 0f,
    val maxAngle: Float = Math.atan(1.0).toFloat() // this means, that we always change something on the value of distance to this object. Because tan(45)=1
): Component()
