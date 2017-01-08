package org.catinthedark.gban.game

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Texture

object Assets {
    fun load(): AssetManager {
        return AssetManager().apply {
            //            load(FONT, BitmapFont::class.java)
            listOf(LOGO, TITLE, GROUND, ROAD, SKY, HEDGE, ENEMY_HEDGE, BACKGROUND).forEach {
                load(it, Texture::class.java)
            }
        }
    }

    val FONT = "font/main.ttf"
    val LOGO = "textures/logo.png"
    val TITLE = "textures/start_screen.png"

    val GROUND = "textures/myGround.gif"
    val ROAD = "textures/road.gif"
    val SKY = "textures/sky.gif"
    val HEDGE = "textures/goodHedge.gif"
    val ENEMY_HEDGE = "textures/goodEnemyHedge.gif"
    val BACKGROUND = "textures/mexico.gif"
}
