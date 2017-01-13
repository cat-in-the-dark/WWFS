package org.catinthedark.gban.game.systems

import com.artemis.Aspect
import com.artemis.ComponentMapper
import com.artemis.annotations.Wire
import com.artemis.systems.IteratingSystem
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputAdapter
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.math.Vector3
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import org.catinthedark.gban.game.Const
import org.catinthedark.gban.game.components.PlayerStateComponent
import org.catinthedark.lib.components.PhysicsComponent

@Wire
class PlayerControlsSystem(val stage: Stage) : IteratingSystem(
    Aspect.all(PlayerStateComponent::class.java, PhysicsComponent::class.java)
) {
    private lateinit var mPlayerState: ComponentMapper<PlayerStateComponent>
    private lateinit var mPhysics: ComponentMapper<PhysicsComponent>

    override fun initialize() {
        Gdx.input.inputProcessor = stage
        stage.addListener(object : ClickListener(Input.Buttons.LEFT) {
            override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                val screenPoint = stage.stageToScreenCoordinates(Vector2(x,y))
                println("($x,$y) $screenPoint")
                //TODO: ЧТО ЗА ХЕРНЯ С КООРДИНАТАМИ???
                return true
            }
        })
    }

    override fun process(entityId: Int) {
        val state = mPlayerState[entityId] ?: return
        val physics = mPhysics[entityId] ?: return

        state.crawling = Gdx.input.isKeyPressed(Const.Controls.STAND_KEY)

        if (Gdx.input.isKeyPressed(Const.Controls.LEFT)) {
            state.moving = true
            physics.velocity.x = -Const.Physics.HORIZONTAL_SPEED
        } else if (Gdx.input.isKeyPressed(Const.Controls.RIGHT)) {
            state.moving = true
            physics.velocity.x = Const.Physics.HORIZONTAL_SPEED
        } else {
            state.moving = false
            physics.velocity.x = 0f
        }
    }
}
