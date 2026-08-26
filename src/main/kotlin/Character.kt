package org.example

abstract class Character(
    val name: String,
    val characterClass: CharacterClass,
    val attackRate: Int,
    health: Int,
    mana: Int,
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

    fun drinkHealthPotion() {
        if (inventory.useItem(Item.HealthPotion)) {
            health += Item.HealthPotion.effectValue
            println("Вы вылечились на 10 hp")
            println("Ваше текущее здоровье: $health")
            println("Ваш инвентарь: ${inventory.getItemCount(Item.HealthPotion)}, ${inventory.getItemCount(Item.ManaPotion)}")
        } else {
            println("В инвентаре нет зелья лечения")
        }
    }

    fun drinkManaPotion() {
        if (inventory.useItem(Item.ManaPotion)) {
            mana += Item.ManaPotion.effectValue
            println("Вы восполнили ману на 3")
            println("Ваш инвентарь: ${inventory.getItemCount(Item.HealthPotion)}, ${inventory.getItemCount(Item.ManaPotion)}")
        } else {
            println("В инвентаре нет зелья маны")
        }
    }
}