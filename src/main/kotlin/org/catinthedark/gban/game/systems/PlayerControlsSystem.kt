package org.catinthedark.gban.game.systems

import com.artemis.Aspect
import com.artemis.ComponentMapper
import com.artemis.annotations.Wire
import com.artemis.systems.IteratingSystem
import com.badlogic.gdx.Gdx
import org.catinthedark.gban.game.Const
import org.catinthedark.gban.game.components.StateComponent
import org.catinthedark.lib.components.PhysicsComponent

@Wire
class PlayerControlsSystem : IteratingSystem(
    Aspect.all(StateComponent::class.java, PhysicsComponent::class.java)
) {
    private lateinit var mState: ComponentMapper<StateComponent>
    private lateinit var mPhysics: ComponentMapper<PhysicsComponent>

    override fun process(entityId: Int) {
        val state = mState[entityId] ?: return
        val physics = mPhysics[entityId] ?: return

        state.crawling = Gdx.input.isKeyPressed(Const.Controls.STAND_KEY)

        if (Gdx.input.isKeyPressed(Const.Controls.LEFT)) {
            physics.velocity.x = -Const.Physics.HORIZONTAL_SPEED
        } else if (Gdx.input.isKeyPressed(Const.Controls.RIGHT)) {
            physics.velocity.x = Const.Physics.HORIZONTAL_SPEED
        } else {
            physics.velocity.x = 0f
        }
    }
}
