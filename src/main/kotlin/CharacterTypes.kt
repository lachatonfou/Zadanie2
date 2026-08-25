package org.example

class Warrior(name: String) : Character(
    name = name,
    characterClass = CharacterClass.Warrior,
    attackRate = 6,
    health = 20,
    mana = 0,
    inventory = mutableListOf(
        Item.HealthPotion,
        Item.HealthPotion
    )
)

class Mage(name: String) : Character(
    name = name,
    characterClass = CharacterClass.Mage,
    attackRate = 8,
    health = 10,
    mana = 3,
    inventory = mutableListOf(
        Item.HealthPotion,
        Item.ManaPotion,
        Item.ManaPotion
    )
) {

    fun castSpell(enemy: Enemy): Boolean {
        val spellDamage = 5
        val manaCost = 1

        if (mana >= manaCost) {
            mana -= manaCost
            enemy.takeDamage(spellDamage)

            println("$name использует заклинание")
            println("Заклинание нанесло $spellDamage урона")
            println("Осталось маны: $mana")
            println("Здоровье противника: ${enemy.health}")

            return true
        } else {
            println("У вас недостаточно маны")
            return false
        }
    }
}

class Rogue(name: String) : Character(
    name = name,
    characterClass = CharacterClass.Rogue,
    attackRate = 10,
    health = 15,
    mana = 0,
    inventory = mutableListOf(
        Item.HealthPotion
    )
)