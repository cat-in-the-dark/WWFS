package org.catinthedark.gban.game

import com.badlogic.gdx.Input

object Const {
    object Screen {
        val WIDTH = 1368
        val HEIGHT = 768
        val ZOOM = 1f
    }

    object UI {
        val PARALLAX_SPEED = 0.08f
        val ANIMATION_SPEED = 1f
    }

    object Controls {
        val STAND_KEY = Input.Keys.CONTROL_LEFT
        val LEFT = Input.Keys.A
        val RIGHT = Input.Keys.D
    }

    object Physics {
        val HORIZONTAL_SPEED = 200f
    }
}
