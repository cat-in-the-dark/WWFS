package org.catinthedark.gban.game

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont

object Assets {
    fun load(): AssetManager {
        return AssetManager().apply {
//            load(FONT, BitmapFont::class.java)
            listOf(LOGO, TITLE).forEach {
                load(it, Texture::class.java)
            }
        }
    }

    val FONT = "font/main.ttf"
    val LOGO = "textures/logo.png"
    val TITLE = "textures/start_screen.png"
}
