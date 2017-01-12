package org.catinthedark.lib.components

import com.artemis.Component
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.TextureRegion

class AnimationComponent(
    val animations: MutableMap<String, Animation<TextureRegion>> = hashMapOf(),
    state: String = ""
): Component() {
    var stateTime: Float = 0f
        private set
    var state: String = state
        set(value) {
            if (field != value) {
                stateTime = 0f
                Gdx.app.debug("AnimationComponent", "Changed state from $value to $field")
                field = value
            }
        }

    val keyFrame: TextureRegion?
        get() = animations[state]?.getKeyFrame(stateTime)

    fun update(delta: Float) {
        if (delta < 0f) throw Exception("OMG delta time can't be negative")
        stateTime += delta
    }
}
