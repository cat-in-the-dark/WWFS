package org.catinthedark.gban.game.systems

import com.artemis.BaseSystem
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.math.Vector3
import org.catinthedark.gban.game.Assets
import org.catinthedark.lib.components.TextureComponent
import org.catinthedark.lib.components.TransformComponent
import org.catinthedark.lib.getTextureRegion

class GameScreenSystem(val am: AssetManager) : BaseSystem() {
    override fun processSystem() {

    }

    override fun initialize() {
        createSky()
        createRoad()
        createGround()
        createHedge()
        createEnemyHedge()
    }

    fun createSky() {
        world.createEntity().edit()
            .add(TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.SKY)))
            .add(TransformComponent(
                pos = Vector3(0f, 204f, 100f)
            ))
    }

    fun createEnemyHedge() {
        world.createEntity().edit()
            .add(TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.ENEMY_HEDGE)))
            .add(TransformComponent(
                pos = Vector3(0f, 0f, 13f)
            ))
    }

    fun createRoad() {
        world.createEntity().edit()
            .add(TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.ROAD)))
            .add(TransformComponent(
                pos = Vector3(0f, 0f, 12f)
            ))
    }

    fun createGround() {
        world.createEntity().edit()
            .add(TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.GROUND)))
            .add(TransformComponent(
                pos = Vector3(0f, 0f, 11f)
            ))
    }

    fun createHedge() {
        world.createEntity().edit()
            .add(TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.HEDGE)))
            .add(TransformComponent(
                pos = Vector3(0f, 0f, 10f)
            ))
    }
}
