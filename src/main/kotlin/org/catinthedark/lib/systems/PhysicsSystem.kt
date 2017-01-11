package org.catinthedark.lib.systems

import com.artemis.Aspect
import com.artemis.ComponentMapper
import com.artemis.systems.IteratingSystem
import org.catinthedark.lib.components.PhysicsComponent
import org.catinthedark.lib.components.TransformComponent

class PhysicsSystem : IteratingSystem(
    Aspect.all(TransformComponent::class.java, PhysicsComponent::class.java)
) {
    private lateinit var mTransform: ComponentMapper<TransformComponent>
    private lateinit var mPhysics: ComponentMapper<PhysicsComponent>

    override fun process(entityId: Int) {
        val transform = mTransform[entityId] ?: return
        val physics = mPhysics[entityId] ?: return

        transform.pos.x += physics.velocity.x * world.delta
        transform.pos.y += physics.velocity.y * world.delta
    }
}
