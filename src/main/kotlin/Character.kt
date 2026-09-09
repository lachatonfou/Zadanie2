package org.example

abstract class Character(
    val name: String,
    val characterClass: CharacterClass,
    val attackRate: Int,
    health: Int,
    mana: Int,
    val defenceRate : Int = 0,
    val inventory: Inventory
) {

    var health: Int = health
        private set

    var mana: Int = mana
        protected set

    abstract fun attack(enemy: Enemy)

    fun takeDamage(damage: Int) {
        health = (health - damage).coerceAtLeast(0)
    }

    fun restoreHealth(amount : Int) {
        health += amount
    }

    fun restoreMana(amount : Int) {
        mana += amount
    }

    fun useItem(item: Item) {
        if (inventory.useItem(item)) {
            item.applyEffect(this)
            println("Вы использовали предмет")
            inventory.toString()
        } else {
            println("Предмета ${item.name} нет в инвентаре")
        }
    }

}