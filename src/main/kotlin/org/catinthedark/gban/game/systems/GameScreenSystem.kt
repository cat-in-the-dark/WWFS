package org.catinthedark.gban.game.systems

import com.artemis.BaseSystem
import com.artemis.Component
import com.artemis.EntityEdit
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.math.Vector3
import org.catinthedark.gban.game.Assets
import org.catinthedark.gban.game.components.ParallaxComponent
import org.catinthedark.gban.game.components.StateComponent
import org.catinthedark.lib.components.TextureComponent
import org.catinthedark.lib.components.TransformComponent
import org.catinthedark.lib.getTextureRegion

class GameScreenSystem(val am: AssetManager) : BaseSystem() {
    override fun processSystem() {

    }

    override fun initialize() {
        val state = StateComponent()
        createSky(state)
        createRoad(state)
        createGround(state)
        createHedge(state)
        createEnemyHedge(state)
        createBackground(state)
        createWaterBar()
        createWaterPump()
        createPlants()
    }

    fun createSky(state: StateComponent) {
        entity(
            state,
            TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.SKY)),
            TransformComponent(
                pos = Vector3(0f, 204f, 100f)),
            ParallaxComponent(
                distance = 0.5f,
                isDistant = false))
    }

    fun createBackground(state: StateComponent) {
        entity(
            state,
            TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.BACKGROUND)),
            TransformComponent(
                pos = Vector3(0f, 285f, 14f)),
            ParallaxComponent(
                distance = 150f,
                isDistant = true))
    }

    fun createEnemyHedge(state: StateComponent) {
        entity(
            state,
            TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.ENEMY_HEDGE)),
            TransformComponent(
                pos = Vector3(0f, 359f, 13f)),
            ParallaxComponent(
                distance = 90f,
                isDistant = true))
    }

    fun createRoad(state: StateComponent) {
        entity(
            state,
            TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.ROAD)),
            TransformComponent(
                pos = Vector3(0f, 295f, 12f)),
            ParallaxComponent(
                distance = 90f,
                isDistant = true))
    }

    fun createGround(state: StateComponent) {
        entity(
            state,
            TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.GROUND)),
            TransformComponent(
                pos = Vector3(0f, -88f, 11f)),
            ParallaxComponent(
                distance = 88f,
                isDistant = false))
    }

    fun createHedge(state: StateComponent) {
        entity(
            state,
            TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.HEDGE)),
            TransformComponent(
                pos = Vector3(0f, 0f, 10f)),
            ParallaxComponent(
                distance = 88f,
                isDistant = false))
    }

    fun createWaterPump() {
        entity(
            TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.WATER_PUMP)),
            TransformComponent(
                pos = Vector3(60f, 20f, 9f)))
    }

    fun createWaterBar() {
        entity(
            TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.WATER_BAR)),
            TransformComponent(
                pos = Vector3(15f, 20f, 9f)))
    }

    fun createPlants() {
        entity(
            TextureComponent(
                center = false,
                texture = am.getTextureRegion(Assets.PLANTS)),
            TransformComponent(
                pos = Vector3(1100f, 20f, 9f)))
    }

    fun entity(vararg components: Component): EntityEdit {
        val e = world.createEntity().edit()
        components.forEach {
            e.add(it)
        }
        return e
    }
}
