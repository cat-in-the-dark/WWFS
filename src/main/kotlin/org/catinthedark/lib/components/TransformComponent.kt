package org.catinthedark.lib.components

import com.artemis.Component
import com.badlogic.gdx.math.Vector3

class TransformComponent(
    val pos: Vector3 = Vector3.Zero,
    var angle: Float = 0f,
    val scale: Vector3 = Vector3(1f,1f,1f)
): Component(), Comparable<TransformComponent> {
    override fun compareTo(other: TransformComponent): Int {
        return this.pos.z.compareTo(other.pos.z)
    }

    val initialPos: Vector3 = pos.cpy()!!
}
