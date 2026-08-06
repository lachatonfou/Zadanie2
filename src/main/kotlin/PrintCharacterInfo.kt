package org.example

fun printCharacterInfo(character: Character) {

    println("Персонаж создан")
    println("Имя: ${character.name}")
    println("Класс: ${character.characterClass}")
    println("Атака: ${character.attackRate}")
    println("Здоровье: ${character.health}")
    println("Мана: ${character.mana}")
    println("Инвентарь: ${character.inventory}")

}