package org.catinthedark.gban.game.systems

import com.artemis.Aspect
import com.artemis.ComponentMapper
import com.artemis.systems.IteratingSystem
import org.catinthedark.gban.game.components.PlayerStateComponent
import org.catinthedark.lib.components.AnimationComponent

class PlayerAnimationController : IteratingSystem(
    Aspect.all(PlayerStateComponent::class.java, AnimationComponent::class.java)
) {
    private lateinit var mPlayerState: ComponentMapper<PlayerStateComponent>
    private lateinit var mAnimation: ComponentMapper<AnimationComponent>

    override fun process(entityId: Int) {
        val state = mPlayerState[entityId] ?: return
        val animation = mAnimation[entityId] ?: return

        if (state.crawling && state.moving) {
            animation.state = "crawling"
        } else if (state.crawling && !state.moving) {
            animation.state = "idleDown"
        } else if (!state.crawling && state.moving) {
            animation.state = "running"
        } else if (!state.crawling && !state.moving) {
            animation.state = "idleUp"
        }
    }
}
