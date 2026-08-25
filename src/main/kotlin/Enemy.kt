package org.example

abstract class Enemy(
    val enemyName: String,
    health: Int,
    val attackRate: Int,
    val defenceRate: Int
) {

    var health: Int = health
        private set

    fun attack(character: Character) {
        character.takeDamage(attackRate)

        println("$enemyName атакует в ответ")
        println("Противник нанес $attackRate урона")
        println("Ваше здоровье: ${character.health}")
    }

    fun takeDamage(damage: Int) {
        health = (health - damage).coerceAtLeast(0)
    }

}