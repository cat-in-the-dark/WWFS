package org.catinthedark.gban.game.screens

import com.artemis.World
import com.artemis.WorldConfigurationBuilder
import com.badlogic.gdx.Screen
import org.catinthedark.gban.game.Assets
import org.catinthedark.gban.game.Const
import org.catinthedark.gban.game.systems.GameScreenSystem
import org.catinthedark.gban.game.systems.ParallaxSystem
import org.catinthedark.gban.game.systems.PlayerAnimationController
import org.catinthedark.gban.game.systems.PlayerControlsSystem
import org.catinthedark.lib.systems.*

class GameScreen(
    val assets: Assets
) : Screen {
    private val viewportSystem: ViewportSystem = ViewportSystem(
        Const.Screen.WIDTH / Const.Screen.ZOOM,
        Const.Screen.HEIGHT / Const.Screen.ZOOM
    )

    private val world: World = World(WorldConfigurationBuilder().dependsOn().with(
        ClearScreenSystem(),
        viewportSystem,
        AnimationSystem(),
        TextureRenderSystem(viewportSystem.mainStage),
        GameScreenSystem(assets),
        ParallaxSystem(Const.UI.PARALLAX_SPEED),
        PlayerControlsSystem(viewportSystem.mainStage),
        PhysicsSystem(),
        PlayerAnimationController()
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
