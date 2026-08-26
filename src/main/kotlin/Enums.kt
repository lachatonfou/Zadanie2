package org.example

enum class CharacterClass {
    Warrior,
    Mage,
    Rogue
}

enum class Item (
    val effectValue: Int
    ) {
        HealthPotion(10),
        ManaPotion(3)
    }
