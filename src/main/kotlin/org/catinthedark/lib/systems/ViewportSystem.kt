package org.catinthedark.lib.systems

import com.artemis.BaseSystem
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.FillViewport
import com.badlogic.gdx.utils.viewport.FitViewport

class ViewportSystem(
    val width: Float,
    val height: Float
) : BaseSystem() {
    val mainStage: Stage = Stage(FillViewport(
        width, height, OrthographicCamera()), SpriteBatch())
    val guiStage: Stage = Stage(FitViewport(
        width, height, OrthographicCamera()), SpriteBatch())

    override fun processSystem() {
        mainStage.viewport.apply()
        guiStage.viewport.apply(true)
        mainStage.act()
        guiStage.act()
    }

    fun resize(width: Int, height: Int) {
        mainStage.viewport.update(width, height)
        guiStage.viewport.update(width, height)
    }
}
