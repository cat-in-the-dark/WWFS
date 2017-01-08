package org.catinthedark.lib

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion

inline fun AssetManager.getTextureRegion(fileName: String): TextureRegion {
    return TextureRegion(this.get(fileName, Texture::class.java))
}
