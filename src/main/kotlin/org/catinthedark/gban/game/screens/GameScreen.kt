package org.catinthedark.gban.game.screens

import com.artemis.World
import com.artemis.WorldConfigurationBuilder
import com.badlogic.gdx.Screen
import com.badlogic.gdx.assets.AssetManager
import org.catinthedark.gban.game.Const
import org.catinthedark.gban.game.systems.GameScreenSystem
import org.catinthedark.gban.game.systems.ParallaxSystem
import org.catinthedark.gban.game.systems.PlayerControlsSystem
import org.catinthedark.lib.systems.ClearScreenSystem
import org.catinthedark.lib.systems.TextureRenderSystem
import org.catinthedark.lib.systems.ViewportSystem

class GameScreen(
    val am: AssetManager
) : Screen {
    private val viewportSystem: ViewportSystem = ViewportSystem(
        Const.Screen.WIDTH / Const.Screen.ZOOM,
        Const.Screen.HEIGHT / Const.Screen.ZOOM
    )

    private val world: World = World(WorldConfigurationBuilder().dependsOn().with(
        ClearScreenSystem(),
        viewportSystem,
        TextureRenderSystem(viewportSystem.mainStage),
        GameScreenSystem(am),
        ParallaxSystem(Const.UI.PARALLAX_SPEED),
        PlayerControlsSystem()
    ).build())

    override fun show() {

    }

    override fun pause() {

    }

    override fun resize(width: Int, height: Int) {
        viewportSystem.resize(width, height)
    }

    override fun hide() {

    }

    override fun render(delta: Float) {
        world.setDelta(delta)
        world.process()
    }

    override fun resume() {

    }

    override fun dispose() {
        world.dispose()
    }
}
