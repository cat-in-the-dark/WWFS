package org.catinthedark.lib

import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.TextureRegion

object AnimationUtils {
    fun loopingAnimation(speed: Float, frames: List<List<TextureRegion>>, vararg frameIndexes: Pair<Int, Int>): Animation<TextureRegion> {
        val array = com.badlogic.gdx.utils.Array<TextureRegion>()
        frameIndexes.forEach {
            array.add(frames[it.first][it.second])
        }
        return Animation(speed, array, Animation.PlayMode.LOOP)
    }

    fun normalAnimation(speed: Float, frames: List<List<TextureRegion>>, vararg frameIndexes: Pair<Int, Int>): Animation<TextureRegion> {
        val array = com.badlogic.gdx.utils.Array<TextureRegion>()
        frameIndexes.forEach {
            array.add(frames[it.first][it.second])
        }
        return Animation(speed, array, Animation.PlayMode.NORMAL)
    }
}
