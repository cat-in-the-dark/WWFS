package org.catinthedark.gban.game.systems

import com.artemis.Aspect
import com.artemis.BaseEntitySystem
import com.artemis.ComponentMapper
import com.artemis.annotations.Wire
import com.badlogic.gdx.math.MathUtils
import org.catinthedark.gban.game.components.ParallaxComponent
import org.catinthedark.lib.components.TransformComponent

@Wire
class ParallaxSystem : BaseEntitySystem(
    Aspect.all(TransformComponent::class.java, ParallaxComponent::class.java)
) {
    private lateinit var mTransform: ComponentMapper<TransformComponent>
    private lateinit var mParallax: ComponentMapper<ParallaxComponent>

    private val minAngle = 0f
    private val maxAngle = Math.atan(1.0).toFloat() // this means, that we always change something on the value of distance to this object. Because tan(45)=1
    private var currentAngle = minAngle
    private val step = 0.02f
    private var direction = -1f

    fun process(entityId: Int) {
        val transform = mTransform[entityId] ?: return
        val parallax = mParallax[entityId] ?: return
        if (currentAngle < minAngle || currentAngle > maxAngle) return

        if (parallax.isDistant) {
            transform.pos.y = transform.initialPos.y - parallax.distance * tan(currentAngle)
        } else {
            transform.pos.y = transform.initialPos.y + parallax.distance * tan(currentAngle)
        }
    }

    override fun processSystem() {
        if (direction > 0) {
            if (currentAngle - direction * step > minAngle) {
                currentAngle -= direction * step
            } else {
                currentAngle = minAngle
                direction *= -1 // TODO - just test
            }
        } else {
            if (currentAngle - direction * step < maxAngle) {
                currentAngle -= direction * step
            } else {
                currentAngle = maxAngle
                direction *= -1 // TODO - just test
            }
        }
        subscription.entities.data.forEach {
            process(it)
        }
    }

    fun tan(angle: Float): Float = MathUtils.clamp(Math.tan(angle.toDouble()), 0.0, 1.0).toFloat()
}
