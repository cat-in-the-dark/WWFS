package org.catinthedark.lib

import com.artemis.Component
import com.artemis.EntityEdit
import com.artemis.World

fun World.entity(vararg components: Component): EntityEdit {
    val e = this.createEntity().edit()
    components.forEach {
        e.add(it)
    }
    return e
}
