package org.catinthedark.lib.systems

import com.artemis.Aspect
import com.artemis.ComponentMapper
import com.artemis.Entity
import com.artemis.annotations.Wire
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.math.Vector3
import com.badlogic.gdx.scenes.scene2d.Stage
import org.catinthedark.lib.components.TextureComponent
import org.catinthedark.lib.components.TransformComponent
import java.util.*

@Wire
class TextureRenderSystem(
    val stage: Stage
) : OrderedIteratingEntitySystem(
    Aspect.all(TextureComponent::class.java, TransformComponent::class.java)
) {
    private lateinit var mTexture: ComponentMapper<TextureComponent>
    private lateinit var mTransform: ComponentMapper<TransformComponent>

    override val comparator: Comparator<Entity>
        get() = Comparator { a, b ->
            val transformA = mTransform[a]
            val transformB = mTransform[b]
            if (transformA != null && transformB != null) {
                transformB.compareTo(transformA)
            } else {
                0
            }
        }

    override fun process(entity: Entity) {
        val textureComponent = mTexture[entity]
        val region = textureComponent.texture
        if (region == null) {
            Gdx.app.error("TextureRenderSystem", "TextureRegion is null.")
            return
        }
        val transformComponent = mTransform[entity]
        val pos = if (textureComponent.center) {
            Vector3(
                transformComponent.pos.x - region.regionWidth.toFloat() / 2,
                transformComponent.pos.y - region.regionHeight.toFloat() / 2,
                transformComponent.pos.z)
        } else {
            transformComponent.pos
        }
        stage.batch.draw(
            region,
            pos.x, pos.y,
            region.regionWidth.toFloat() / 2, region.regionHeight.toFloat() / 2,
            region.regionWidth.toFloat(), region.regionHeight.toFloat(),
            1f, 1f,
            transformComponent.angle
        )
    }

    override fun begin() {
        stage.batch.begin()
    }

    override fun end() {
        stage.batch.end()
        stage.draw()
    }
}
