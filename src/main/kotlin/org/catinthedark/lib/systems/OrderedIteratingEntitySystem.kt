package org.catinthedark.lib.systems

import com.artemis.Aspect
import com.artemis.Entity
import com.artemis.EntitySystem
import java.util.*

abstract class OrderedIteratingEntitySystem(
    aspect: Aspect.Builder
) : EntitySystem(aspect) {
    private val sortedEntities: MutableList<Entity> = arrayListOf()
    private var unsorted: Boolean = true

    abstract val comparator: Comparator<Entity>
    abstract fun process(entity: Entity)

    override fun processSystem() {
        if (unsorted) {
            sortedEntities.sortWith(comparator)
            unsorted = false
        }

        sortedEntities.forEach { process(it) }
    }

    override fun inserted(e: Entity?) {
        if (e == null) return
        sortedEntities.add(e)
        unsorted = true
    }

    override fun removed(e: Entity?) {
        if (e == null) return
        sortedEntities.remove(e)
    }
}
