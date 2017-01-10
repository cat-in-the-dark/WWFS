package org.catinthedark.gban.game.systems

import com.artemis.Aspect
import com.artemis.ComponentMapper
import com.artemis.annotations.Wire
import com.artemis.systems.IteratingSystem
import com.badlogic.gdx.math.MathUtils
import org.catinthedark.gban.game.components.ParallaxComponent
import org.catinthedark.gban.game.components.StateComponent
import org.catinthedark.lib.components.TransformComponent

@Wire
class ParallaxSystem(
    private val step: Float = 0.02f
) : IteratingSystem(
    Aspect.all(TransformComponent::class.java, ParallaxComponent::class.java, StateComponent::class.java)
) {
    private lateinit var mTransform: ComponentMapper<TransformComponent>
    private lateinit var mParallax: ComponentMapper<ParallaxComponent>
    private lateinit var mState: ComponentMapper<StateComponent>

    override fun process(entityId: Int) {
        val transform = mTransform[entityId] ?: return
        val parallax = mParallax[entityId] ?: return
        val state = mState[entityId] ?: return

        parallax.direction = if (state.crawling) -1f else 1f

        updateAngle(parallax)

        with(parallax, {
            if (currentAngle < minAngle || currentAngle > maxAngle) return

            if (isDistant) {
                transform.pos.y = transform.initialPos.y - distance * tan(currentAngle)
            } else {
                transform.pos.y = transform.initialPos.y + distance * tan(currentAngle)
            }
        })
    }

    private fun updateAngle(parallax: ParallaxComponent) {
        with(parallax, {
            if (direction > 0) {
                if (currentAngle - direction * step > minAngle) {
                    currentAngle -= direction * step
                } else {
                    currentAngle = minAngle
                }
            } else {
                if (currentAngle - direction * step < maxAngle) {
                    currentAngle -= direction * step
                } else {
                    currentAngle = maxAngle
                }
            }
        })
    }

    fun tan(angle: Float): Float = MathUtils.clamp(Math.tan(angle.toDouble()), 0.0, 1.0).toFloat()
}
