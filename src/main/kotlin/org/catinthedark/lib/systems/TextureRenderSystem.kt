package org.catinthedark.lib.systems

import com.artemis.Aspect
import com.artemis.ComponentMapper
import com.artemis.annotations.Wire
import com.artemis.systems.IteratingSystem
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.math.Vector3
import org.catinthedark.lib.components.TextureComponent
import org.catinthedark.lib.components.TransformComponent

@Wire
class TextureRenderSystem(
    val batch: Batch
) : IteratingSystem(
    Aspect.all(TextureComponent::class.java, TransformComponent::class.java)
) {
    private lateinit var mTexture: ComponentMapper<TextureComponent>
    private lateinit var mTransform: ComponentMapper<TransformComponent>

    override fun process(entityId: Int) {
        val textureComponent = mTexture[entityId]
        val region = textureComponent.texture ?: return
        val transformComponent = mTransform[entityId]
        val pos = if (textureComponent.center) {
            Vector3(
                transformComponent.pos.x - region.regionWidth.toFloat() / 2,
                transformComponent.pos.y - region.regionHeight.toFloat() / 2,
                transformComponent.pos.z)
        } else {
            transformComponent.pos
        }
        batch.draw(
            region,
            pos.x, pos.y,
            region.regionWidth.toFloat() / 2, region.regionHeight.toFloat() / 2,
            region.regionWidth.toFloat(), region.regionHeight.toFloat(),
            1f, 1f,
            transformComponent.angle
        )
    }

    override fun begin() {
        batch.begin()
    }

    override fun end() {
        batch.end()
    }
}
