package org.catinthedark.gban.game.systems

import com.artemis.BaseSystem
import com.badlogic.gdx.math.Vector3
import org.catinthedark.gban.game.Assets
import org.catinthedark.gban.game.components.ParallaxComponent
import org.catinthedark.gban.game.components.StateComponent
import org.catinthedark.lib.components.PhysicsComponent
import org.catinthedark.lib.components.TextureComponent
import org.catinthedark.lib.components.TransformComponent
import org.catinthedark.lib.entity

class GameScreenSystem(val assets: Assets) : BaseSystem() {
    var pack = assets.goodThemePack

    override fun processSystem() {
    }

    override fun initialize() {
        val state = StateComponent()
        createPlayer(state)
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

    fun createPlayer(state: StateComponent) {
        world.entity(
            state,
            TextureComponent(
                center = true,
                texture = pack.player.up),
            TransformComponent(
                pos = Vector3(200f, 200f, 0f)),
            PhysicsComponent()
        )
    }

    fun createSky(state: StateComponent) {
        world.entity(
            state,
            TextureComponent(
                center = false,
                texture = pack.sky),
            TransformComponent(
                pos = Vector3(0f, 204f, 100f)),
            ParallaxComponent(
                distance = 0.5f,
                isDistant = false))
    }

    fun createBackground(state: StateComponent) {
        world.entity(
            state,
            TextureComponent(
                center = false,
                texture = pack.background),
            TransformComponent(
                pos = Vector3(0f, 285f, 14f)),
            ParallaxComponent(
                distance = 150f,
                isDistant = true))
    }

    fun createEnemyHedge(state: StateComponent) {
        world.entity(
            state,
            TextureComponent(
                center = false,
                texture = pack.enemy_hedge),
            TransformComponent(
                pos = Vector3(0f, 359f, 13f)),
            ParallaxComponent(
                distance = 90f,
                isDistant = true))
    }

    fun createRoad(state: StateComponent) {
        world.entity(
            state,
            TextureComponent(
                center = false,
                texture = pack.road),
            TransformComponent(
                pos = Vector3(0f, 295f, 12f)),
            ParallaxComponent(
                distance = 90f,
                isDistant = true))
    }

    fun createGround(state: StateComponent) {
        world.entity(
            state,
            TextureComponent(
                center = false,
                texture = pack.ground),
            TransformComponent(
                pos = Vector3(0f, -88f, 11f)),
            ParallaxComponent(
                distance = 88f,
                isDistant = false))
    }

    fun createHedge(state: StateComponent) {
        world.entity(
            state,
            TextureComponent(
                center = false,
                texture = pack.hedge),
            TransformComponent(
                pos = Vector3(0f, 0f, 10f)),
            ParallaxComponent(
                distance = 88f,
                isDistant = false))
    }

    fun createWaterPump() {
        world.entity(
            TextureComponent(
                center = false,
                texture = pack.waterPump),
            TransformComponent(
                pos = Vector3(60f, 20f, 9f)))
    }

    fun createWaterBar() {
        world.entity(
            TextureComponent(
                center = false,
                texture = pack.waterBar),
            TransformComponent(
                pos = Vector3(15f, 20f, 9f)))
    }

    fun createPlants() {
        world.entity(
            TextureComponent(
                center = false,
                texture = pack.plants[2]),
            TransformComponent(
                pos = Vector3(1100f, 20f, 9f)))
    }
}
