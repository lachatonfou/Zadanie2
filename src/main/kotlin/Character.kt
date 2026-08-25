package org.example

abstract class Character(
    val name: String,
    val characterClass: CharacterClass,
    val attackRate: Int,
    health: Int,
    mana: Int,
    inventory: List<Item>
) {

    var health: Int = health
        private set

    var mana: Int = mana
        protected set

    private val inventoryList: MutableList<Item> = inventory.toMutableList()

    val inventory: List<Item>
        get() = inventoryList

    fun attack(enemy: Enemy) {
        val damage = (attackRate - enemy.defenceRate).coerceAtLeast(0)
        enemy.takeDamage(damage)

        println("$name атакует противника")
        println("Нанесено урона: $damage")
        println("Здоровье противника: ${enemy.health}")
    }

    fun takeDamage(damage: Int) {
        health = (health - damage).coerceAtLeast(0)
    }

    fun drinkHealthPotion() {
        if (Item.HealthPotion in inventoryList) {
            inventoryList.remove(Item.HealthPotion)
            health += 10
            println("Вы вылечились на 10 hp")
            println("Ваше текущее здоровье: $health")
        } else {
            println("В инвентаре нет зелья лечения")
        }
    }

    fun drinkManaPotion() {
        if (Item.ManaPotion in inventoryList) {
            inventoryList.remove(Item.ManaPotion)
            mana += 3
            println("Вы восполнили ману на 3")
        } else {
            println("В инвентаре нет зелья маны")
        }
    }
}