package org.catinthedark.lib.systems

import com.artemis.Aspect
import com.artemis.ComponentMapper
import com.artemis.systems.IteratingSystem
import com.badlogic.gdx.Gdx
import org.catinthedark.lib.components.AnimationComponent
import org.catinthedark.lib.components.TextureComponent

class AnimationSystem : IteratingSystem(
  Aspect.all(TextureComponent::class.java, AnimationComponent::class.java)
) {
    private lateinit var mTexture: ComponentMapper<TextureComponent>
    private lateinit var mAnimation: ComponentMapper<AnimationComponent>

    override fun process(entityId: Int) {
        val texture = mTexture[entityId]
        val animation = mAnimation[entityId]

        animation.update(world.delta)
        if (animation.keyFrame == null) {
            Gdx.app.error("AnimationSystem", "There is no animation for ${animation.state}")
            return
        }

        texture.texture = animation.keyFrame
    }
}
