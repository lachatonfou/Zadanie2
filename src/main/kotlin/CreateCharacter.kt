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

    while (true) {
        println("Введите класс:")

        println("1. Warrior")
        println("2. Mage")
        println("3. Rogue")

        when (readln().trim()) {
            "1" -> return CharacterClass.Warrior
            "2" -> return CharacterClass.Mage
            "3" -> return CharacterClass.Rogue
            else -> println("Некорректный ввод. Введите 1, 2 или 3")
        }
    }
}