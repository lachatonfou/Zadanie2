package org.example

fun createCharacter(): Character {

    println("Введите имя:")
    val nameInput = readln()
    val character = CharacterFactory.createCharacter(
        name = nameInput,
        characterClass = readCharacterClass()
    )

    return character
}

fun readCharacterClass(): CharacterClass {

    println("Введите класс (Warrior / Mage / Rogue):")
    val characterClassInput = readln()
    return CharacterClass.valueOf(characterClassInput)

}

fun printCharacterInfo(character: Character) {

    println("Персонаж создан")
    println("Имя: ${character.name}")
    println("Класс: ${character.characterClass}")
    println("Атака: ${character.attackRate}")
    println("Здоровье: ${character.health}")
    println("Мана: ${character.mana}")
    println("Инвентарь: ${character.inventory}")

}