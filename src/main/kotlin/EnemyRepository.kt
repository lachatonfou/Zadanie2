package org.example

object EnemyRepository {

    private val enemies: MutableList<Enemy> = mutableListOf(
        Rat(),
        Kobold(),
        Orc(),
        Dragon()
    )

    fun hasEnemies(): Boolean {
        return enemies.isNotEmpty()
    }

    fun getNextEnemy(): Enemy {
        return enemies.removeFirst()
    }
}