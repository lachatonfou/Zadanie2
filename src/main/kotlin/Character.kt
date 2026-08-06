package org.example

abstract class Character(
    val name: String,
    val characterClass: CharacterClass,
    var attackRate: Int,
    var health: Int,
    var mana: Int,
    val inventory: MutableList<Item>
) {
    fun attack(enemy: Enemy) {
        val damage = (attackRate - enemy.defenceRate).coerceAtLeast(0)
        enemy.health = (enemy.health - damage).coerceAtLeast(0)

        println("$name атакует противника")
        println("Нанесено урона: $damage")
        println("Здоровье противника: ${enemy.health}")
    }

    fun drinkHealthPotion() {
        if (Item.HealthPotion in inventory) {
            inventory.remove(Item.HealthPotion)
            health += 10
            println("Вы вылечились на 10 hp")
            println("Ваше текущее здоровье: $health")
        } else {
            println("В инвентаре нет зелья лечения")
        }
    }

    fun drinkManaPotion() {
        if (Item.ManaPotion in inventory) {
            inventory.remove(Item.ManaPotion)
            mana += 3
            println("Вы восполнили ману на 3")
        } else {
            println("В инвентаре нет зелья маны")
        }
    }
}