package org.catinthedark.gban.game.systems

import com.artemis.BaseSystem
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import org.catinthedark.gban.game.Assets
import org.catinthedark.lib.components.TextureComponent
import org.catinthedark.lib.components.TransformComponent

class TitleScreenSystem(
    val am: AssetManager
): BaseSystem() {

    override fun processSystem() {

    }

    override fun end() {
        world
            .createEntity().edit()
            .add(TextureComponent(
                center = false,
                texture = TextureRegion(am.get(Assets.TITLE, Texture::class.java))))
            .add(TransformComponent())
    }
}
