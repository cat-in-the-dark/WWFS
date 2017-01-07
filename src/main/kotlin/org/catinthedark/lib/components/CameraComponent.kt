package org.catinthedark.lib.components

import com.artemis.Component
import com.artemis.annotations.Transient
import com.badlogic.gdx.graphics.Camera

@Transient
class CameraComponent(
    var camera: Camera,
    var zoom: Float = 1f
) : Component()
