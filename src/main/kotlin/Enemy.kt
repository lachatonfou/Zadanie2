package org.example

abstract class Enemy(
    val enemyName: String,
    var health: Int,
    val attackRate: Int,
    val defenceRate: Int
) {

    fun attack(character: Character) {
        character.health = (character.health - attackRate).coerceAtLeast(0)
        println("$enemyName атакует в ответ")
        println("Противник нанес $attackRate урона")
        println("Ваше здоровье: ${character.health}")
    }

}