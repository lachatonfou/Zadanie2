package org.example

fun main() {

    val character = createCharacter()

    printCharacterInfo(character)

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

fun fight(character: Character, enemy: Enemy) {
    while (character.health > 0 && enemy.health > 0) {
        chooseAction(character, enemy)
    }

    if (enemy.health <= 0) {
        println("${enemy.enemyName} побежден!")
    }
}

fun chooseAction(character: Character, enemy: Enemy) {
    println("Выберите действие (Атаковать, Выпить зелье лечения, Выпить зелье маны, Использовать заклинание):")

    when (readln()) {
        "Атаковать" -> {
            character.attack(enemy)
            if (enemy.health > 0) {
                enemy.attack(character)
            }
        }

        "Выпить зелье лечения" -> character.drinkHealthPotion()
        "Выпить зелье маны" -> character.drinkManaPotion()
        "Использовать заклинание" -> {
            if (character is Mage) {
                val spellWasCast = character.castSpell(enemy)

                if (spellWasCast && enemy.health > 0) {
                    enemy.attack(character)
                }
            } else {
                println("Этот персонаж не умеет использовать заклинания")
            }
        }
    }
}