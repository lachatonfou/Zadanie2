package org.example

class Inventory(
    initialItems: Map<Item, Int> = emptyMap()
) {
    private val items: MutableMap<Item, Int> = initialItems.toMutableMap()

    fun useItem(item: Item): Boolean {
        val count = items[item] ?: 0

        if (count <= 0) {
            return false
        }

        items[item] = count - 1
        return true
    }

    override fun toString(): String {
        return items.entries.joinToString {
            "${it.key.name}: ${it.value}"
        }
    }

}