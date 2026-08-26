package org.example

class Inventory(
    healthPotionCount: Int = 0,
    manaPotionCount: Int = 0
) {
    private val items: MutableMap<Item, Int> = mutableMapOf(
        Item.HealthPotion to healthPotionCount,
        Item.ManaPotion to manaPotionCount
    )

    fun useItem(item: Item): Boolean {
        val count = items[item] ?: 0

        if (count <= 0) {
            return false
        }

        items[item] = count - 1
        return true
    }

    fun getItemCount(item: Item): Int {
        return items[item] ?: 0
    }

    override fun toString(): String {
        return "HealthPotion: ${getItemCount(Item.HealthPotion)}, " +
                "ManaPotion: ${getItemCount(Item.ManaPotion)}"
    }
}