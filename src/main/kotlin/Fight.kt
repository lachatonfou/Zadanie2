package org.example

fun fight(character: Character, enemy: Enemy) {

    while (character.health > 0 && enemy.health > 0) {
        chooseAction(character, enemy)
    }

    if (enemy.health <= 0) {
        println("${enemy.enemyName} побежден!")
    }

}