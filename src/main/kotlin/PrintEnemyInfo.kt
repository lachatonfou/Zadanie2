package org.example

fun printEnemyInfo(enemy: Enemy) {

    println("Атака противника: ${enemy.attackRate}")
    println("Здоровье противника: ${enemy.health}")
    println("Защита противника: ${enemy.defenceRate}")

}