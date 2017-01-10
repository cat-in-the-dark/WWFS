package org.catinthedark.gban.game.systems

import com.artemis.Aspect
import com.artemis.ComponentMapper
import com.artemis.annotations.Wire
import com.artemis.systems.IteratingSystem
import com.badlogic.gdx.Gdx
import org.catinthedark.gban.game.Const
import org.catinthedark.gban.game.components.StateComponent

@Wire
class PlayerControlsSystem : IteratingSystem(
    Aspect.all(StateComponent::class.java)
) {
    private lateinit var mState: ComponentMapper<StateComponent>

    override fun process(entityId: Int) {
        val state = mState[entityId]

        state.crawling = Gdx.input.isKeyPressed(Const.Controls.STAND_KEY)
    }
}
