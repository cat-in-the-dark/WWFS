package org.catinthedark.lib.components

import com.artemis.Component
import com.artemis.annotations.Transient
import com.badlogic.gdx.graphics.g2d.TextureRegion

@Transient
class TextureComponent(
    var texture: TextureRegion? = null,
    var flipX: Boolean = false,
    var flipY: Boolean = false,
    var orderInLayer: Int = 0,
    var center: Boolean = true
) : Component()
