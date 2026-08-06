package org.example

object EnemyRepository {

    val enemies: MutableList<Enemy> = mutableListOf(
        Rat(),
        Kobold(),
        Orc(),
        Dragon()
    )
}