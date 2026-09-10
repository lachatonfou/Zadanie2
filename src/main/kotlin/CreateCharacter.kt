package org.example

fun createCharacter(): Character {

    GamePrint.printEnterName()
    val nameInput = readln()
    val character = chooseCharacter(
        name = nameInput,
        characterClass = readCharacterClass()
    )
    GamePrint.printCharacterInfo(character)

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

    while (true) {
        GamePrint.printCreateCharacter()

        when (readln().trim()) {
            "1" -> return CharacterClass.Warrior
            "2" -> return CharacterClass.Mage
            "3" -> return CharacterClass.Rogue
            else ->
                GamePrint.printIncorrectInput()
        }
    }
}