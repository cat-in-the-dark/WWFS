package org.catinthedark.lib.systems

import com.artemis.BaseSystem
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20

class ClearScreenSystem(
    val color: Color = Color.BLACK
) : BaseSystem() {
    override fun processSystem() {
        Gdx.gl.glClearColor(color.r, color.g, color.b, 0f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT)
    }
}
