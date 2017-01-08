package org.catinthedark.gban.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import org.catinthedark.gban.game.GbanGame

object DesktopLauncher {
    @JvmStatic
    fun main(args: Array<String>) {
        System.setProperty("org.lwjgl.opengl.Display.allowSoftwareOpenGL", "true")
        LwjglApplication(GbanGame(), LwjglApplicationConfiguration().apply {
            title = "GBAN"
            width = 1161
            height = 652
        })
    }
}
