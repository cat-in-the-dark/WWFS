package org.catinthedark.gban.game.systems

import com.artemis.BaseSystem
import com.badlogic.gdx.graphics.g2d.TextureRegion
import org.catinthedark.gban.game.Assets
import org.catinthedark.lib.components.TextureComponent
import org.catinthedark.lib.components.TransformComponent
import org.catinthedark.lib.entity

class TitleScreenSystem(
    val assets: Assets
) : BaseSystem() {

    override fun processSystem() {

    }

    override fun initialize() {
        world.entity(
            TextureComponent(
                center = false,
                texture = TextureRegion(assets.title)),
            TransformComponent())
    }
}
