package org.example

object CharacterFactory {

    fun createCharacter(
        name: String,
        characterClass: CharacterClass
    ): Character {
        return when (characterClass) {
            CharacterClass.Warrior -> Warrior(name)
            CharacterClass.Mage -> Mage(name)
            CharacterClass.Rogue -> Rogue(name)
        }
    }
}