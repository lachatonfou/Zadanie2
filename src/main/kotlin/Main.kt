package org.example

fun main() {

    val character = createCharacter()

    while (
        character.health > 0 && EnemyRepository.enemies.isNotEmpty()
    ) {
        val enemy = EnemyRepository.enemies.removeFirst()
        println("Перед вами ${enemy.enemyName}")
        printEnemyInfo(enemy)

        fight(character, enemy)
    }

    if (character.health <= 0) {
        println("Персонаж погиб. Игра окончена")
    } else {
        println("Все противники погибли. Вы победили!")
    }
}