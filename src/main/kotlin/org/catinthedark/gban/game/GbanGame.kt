package org.catinthedark.gban.game

import com.badlogic.gdx.Game
import org.catinthedark.gban.game.screens.TitleScreen

class GbanGame: Game() {
    override fun create() {
        val am = Assets.load()
        am.finishLoading() // TODO: do it async!
        setScreen(TitleScreen(am))
    }
}
