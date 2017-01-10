package org.catinthedark.lib

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion

fun AssetManager.getTextureRegion(fileName: String): TextureRegion {
    return TextureRegion(this.get(fileName, Texture::class.java))
}

fun AssetManager.getTextureRegions(fileName: String, tileWidth: Int, tileHeight: Int): List<List<TextureRegion>> {
    return TextureRegion
        .split(this.get(fileName, Texture::class.java), tileWidth, tileHeight)
        .map { it.toList() }
}
