package org.example

fun playGame() {

    val character = createCharacter()

    while (
    character.health > 0 && EnemyRepository.hasEnemies()
    ) {
        val enemy = EnemyRepository.getNextEnemy()
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