package org.catinthedark.gban.game

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import org.catinthedark.gban.game.Const.UI.ANIMATION_SPEED
import org.catinthedark.lib.AnimationUtils.loopingAnimation
import org.catinthedark.lib.AnimationUtils.normalAnimation
import org.catinthedark.lib.getTextureRegion
import org.catinthedark.lib.getTextureRegions

class Assets(
    val am: AssetManager
) {
    companion object {
        fun load(): AssetManager {
            return AssetManager().apply {
                listOf(
                    "textures/logo.png",
                    "textures/start_screen.png",

                    "textures/myGround.gif",
                    "textures/road.gif",
                    "textures/sky.gif",
                    "textures/water_bar.gif",
                    "textures/water_pump.gif",

                    "textures/goodHedge.gif",
                    "textures/goodEnemyHedge.gif",
                    "textures/mexico.gif",
                    "textures/corn1.gif",
                    "textures/corn2.gif",
                    "textures/corn3.gif",
                    "textures/player_good.gif",
                    "textures/upbar_good.gif",
                    "textures/enemy_ugly.gif",
                    "textures/hat_ugly.png",

                    "textures/uglyHedge.gif",
                    "textures/uglyEnemyHedge.gif",
                    "textures/america.gif",
                    "textures/tomatos1.gif",
                    "textures/tomatos2.gif",
                    "textures/tomatos3.gif",
                    "textures/player_ugly.gif",
                    "textures/upbar_ugly.gif",
                    "textures/enemy_good.gif",
                    "textures/hat_good.png"
                ).forEach {
                    load(it, Texture::class.java)
                }
            }
        }
    }

    val logo = am.getTextureRegion("textures/logo.png")
    val title = am.getTextureRegion("textures/start_screen.png")

    val goodThemePack = ThemePack(
        ground = am.getTextureRegion("textures/myGround.gif"),
        road = am.getTextureRegion("textures/road.gif"),
        sky = am.getTextureRegion("textures/sky.gif"),
        hedge = am.getTextureRegion("textures/goodHedge.gif"),
        enemy_hedge = am.getTextureRegion("textures/goodEnemyHedge.gif"),
        background = am.getTextureRegion("textures/mexico.gif"),
        plants = listOf(
            am.getTextureRegion("textures/corn1.gif"),
            am.getTextureRegion("textures/corn2.gif"),
            am.getTextureRegion("textures/corn3.gif")),
        player = PlayerPack(
            am.getTextureRegions("textures/player_good.gif", 320, 360)),
        waterBar = am.getTextureRegion("textures/water_bar.gif"),
        waterPump = am.getTextureRegion("textures/water_pump.gif"),
        uiBar = am.getTextureRegion("textures/upbar_good.gif"),
        enemy = EnemyPack(
            am.getTextureRegions("textures/enemy_ugly.gif", 104, 80),
            am.getTextureRegion("textures/hat_ugly.png")
        )
    )

    val uglyThemePack = ThemePack(
        ground = am.getTextureRegion("textures/myGround.gif"),
        road = am.getTextureRegion("textures/road.gif"),
        sky = am.getTextureRegion("textures/sky.gif"),
        hedge = am.getTextureRegion("textures/uglyHedge.gif"),
        enemy_hedge = am.getTextureRegion("textures/uglyEnemyHedge.gif"),
        background = am.getTextureRegion("textures/america.gif"),
        plants = listOf(
            am.getTextureRegion("textures/tomatos1.gif"),
            am.getTextureRegion("textures/tomatos2.gif"),
            am.getTextureRegion("textures/tomatos3.gif")),
        player = PlayerPack(
            am.getTextureRegions("textures/player_ugly.gif", 320, 360)),
        waterBar = am.getTextureRegion("textures/water_bar.gif"),
        waterPump = am.getTextureRegion("textures/water_pump.gif"),
        uiBar = am.getTextureRegion("textures/upbar_ugly.gif"),
        enemy = EnemyPack(
            am.getTextureRegions("textures/enemy_good.gif", 104, 80),
            am.getTextureRegion("textures/hat_good.png")
        )
    )

    data class ThemePack(
        val ground: TextureRegion,
        val road: TextureRegion,
        val sky: TextureRegion,
        val hedge: TextureRegion,
        val enemy_hedge: TextureRegion,
        val background: TextureRegion,
        val plants: List<TextureRegion>,
        val player: PlayerPack,
        val waterPump: TextureRegion,
        val waterBar: TextureRegion,
        val uiBar: TextureRegion,
        val enemy: EnemyPack
    )

    data class PlayerPack(
        val frames: List<List<TextureRegion>>
    ) {
        val up = frames[0][0]
        val down = frames[0][1]
        val shooting = normalAnimation(ANIMATION_SPEED, frames,
            Pair(0, 0), Pair(0, 2), Pair(0, 0))
        val running = loopingAnimation(ANIMATION_SPEED, frames,
            Pair(0, 0), Pair(0, 5), Pair(0, 6))
        val crawling = loopingAnimation(ANIMATION_SPEED, frames,
            Pair(0, 1), Pair(0, 3), Pair(0, 4))
        val killed = frames[0][7]
    }

    data class EnemyPack(
        val frames: List<List<TextureRegion>>,
        val hat: TextureRegion
    ) {
        val up = frames[0][0]
        val shooting = normalAnimation(ANIMATION_SPEED, frames,
            Pair(0, 0), Pair(0, 1), Pair(0, 0))
    }
}
