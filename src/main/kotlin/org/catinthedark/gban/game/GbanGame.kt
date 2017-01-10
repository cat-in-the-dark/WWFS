package org.catinthedark.gban.game

import com.badlogic.gdx.Game
import org.catinthedark.gban.game.screens.GameScreen
import org.catinthedark.gban.game.screens.TitleScreen

class GbanGame: Game() {
    override fun create() {
        val am = Assets.load()
        am.finishLoading() // TODO: do it async!
        val assets = Assets(am)
//        setScreen(TitleScreen(assets))
        setScreen(GameScreen(assets))
    }
}
