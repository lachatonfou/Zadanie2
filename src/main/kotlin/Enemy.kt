package org.example

abstract class Enemy(
    val enemyName: String,
    health: Int,
    val attackRate: Int,
    val defenceRate: Int
) {

    var health: Int = health
        private set

    fun attack(character: Character) : Int{
        val damage = DamageCalculator.calculateDamage(attackRate, character.defenceRate)
        character.takeDamage(damage)

        return damage
    }

    fun takeDamage(damage: Int) {
        health = (health - damage).coerceAtLeast(0)
    }

}