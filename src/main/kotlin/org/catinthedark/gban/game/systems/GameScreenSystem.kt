package org.catinthedark.gban.game.systems

import com.artemis.BaseSystem
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.math.Vector3
import org.catinthedark.gban.game.Assets
import org.catinthedark.gban.game.components.ParallaxComponent
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
        createBackground()
        createWaterBar()
        createWaterPump()
        createPlants()
    }

    fun createSky() {
        world.createEntity().edit()
            .add(TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.SKY)))
            .add(TransformComponent(
                pos = Vector3(0f, 204f, 100f)
            ))
            .add(ParallaxComponent(
                distance = 0.5f,
                isDistant = false
            ))
    }

    fun createBackground() {
        world.createEntity().edit()
            .add(TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.BACKGROUND)))
            .add(TransformComponent(
                pos = Vector3(0f, 285f, 14f)
            ))
            .add(ParallaxComponent(
                distance = 150f,
                isDistant = true
            ))
    }

    fun createEnemyHedge() {
        world.createEntity().edit()
            .add(TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.ENEMY_HEDGE)))
            .add(TransformComponent(
                pos = Vector3(0f, 359f, 13f)
            ))
            .add(ParallaxComponent(
                distance = 90f,
                isDistant = true
            ))
    }

    fun createRoad() {
        world.createEntity().edit()
            .add(TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.ROAD)))
            .add(TransformComponent(
                pos = Vector3(0f, 295f, 12f)
            ))
            .add(ParallaxComponent(
                distance = 90f,
                isDistant = true
            ))
    }

    fun createGround() {
        world.createEntity().edit()
            .add(TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.GROUND)))
            .add(TransformComponent(
                pos = Vector3(0f, -88f, 11f)
            ))
            .add(ParallaxComponent(
                distance = 88f,
                isDistant = false
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
            .add(ParallaxComponent(
                distance = 88f,
                isDistant = false
            ))
    }

    fun createWaterPump() {
        world.createEntity().edit()
            .add(TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.WATER_PUMP)))
            .add(TransformComponent(
                pos = Vector3(60f, 20f, 9f)
            ))
    }

    fun createWaterBar() {
        world.createEntity().edit()
            .add(TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.WATER_BAR)))
            .add(TransformComponent(
                pos = Vector3(15f, 20f, 9f)
            ))
    }

    fun createPlants() {
        world.createEntity().edit()
            .add(TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.PLANTS)))
            .add(TransformComponent(
                pos = Vector3(1100f, 20f, 9f)
            ))
    }
}
