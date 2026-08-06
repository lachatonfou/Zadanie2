package org.example

fun createCharacter(): Character {

    println("Введите имя:")
    val nameInput = readln()
    val character = chooseCharacter(
        name = nameInput,
        characterClass = readCharacterClass()
    )
    printCharacterInfo(character)

    return character
}

fun chooseCharacter(
    name: String,
    characterClass: CharacterClass
): Character {
    return when (characterClass) {
        CharacterClass.Warrior -> Warrior(name)
        CharacterClass.Mage -> Mage(name)
        CharacterClass.Rogue -> Rogue(name)
    }
}

fun readCharacterClass(): CharacterClass {

    println("Введите класс (Warrior / Mage / Rogue):")
    val characterClassInput = readln()
    return CharacterClass.valueOf(characterClassInput)

}