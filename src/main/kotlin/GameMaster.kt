package org.example

class GameMaster {

    private val gamePrint = GamePrint()

    fun startGame() {
        val character = createCharacter()

        while (character.health > 0 && EnemyRepository.hasEnemies()) {
            val enemy = EnemyRepository.getNextEnemy()

            gamePrint.printEnemyAppeared(enemy)
            fight(character, enemy)
        }

        if (character.health <= 0) {
            gamePrint.printCharacterDie()
        } else {
            gamePrint.printGameVictory()
        }
    }

    private fun fight(character: Character, enemy: Enemy) {
        while (character.health > 0 && enemy.health > 0) {
            chooseAction(character, enemy)
        }

        if (enemy.health <= 0) {
            gamePrint.printEnemyDie(enemy)
        }
    }

    private fun chooseAction(character: Character, enemy: Enemy) {
        while (true) {
            gamePrint.printChooseAction()

            when (readln().trim()) {

                "1" -> {
                    characterAttack(character, enemy)
                    return
                }

                "2" -> {
                    useItem(character, HealthPotion)
                    return
                }

                "3" -> {
                    useItem(character, ManaPotion)
                    return
                }

                "4" -> {
                    useMagic(character, enemy)
                    return
                }

                else -> {
                    gamePrint.printIncorrectInput()
                }
            }
        }
    }

    private fun characterAttack(character: Character, enemy: Enemy) {
        val damage = character.attack(enemy)

        gamePrint.printCharacterAttacked(character, enemy, damage)

        if (enemy.health > 0) {
            enemyAttack(enemy, character)
        }
    }

    private fun enemyAttack(enemy: Enemy, character: Character) {
        val damage = enemy.attack(character)

        gamePrint.printEnemyAttacked(character, enemy, damage)
    }

    private fun useItem(character: Character, item: Item) {
        val itemWasUsed = character.useItem(item)

        if (itemWasUsed) {
            gamePrint.printSuccessfulUseItem(item)
            gamePrint.printInventory(character)
            gamePrint.printCharacterHealth(character)
            gamePrint.printCharacterMana(character)
        } else {
            gamePrint.printFailedUseItem(item)
        }
    }

    private fun useMagic(character: Character, enemy: Enemy) {
        if (character !is UseMagic) {
            gamePrint.printCannotUseMagic()
            return
        }

        val damage = character.castSpell(enemy)

        if (damage != null) {
            gamePrint.printCharacterAttackedMagic(character, enemy, damage)

            if (enemy.health > 0) {
                enemyAttack(enemy, character)
            }
        } else {
            gamePrint.printNotEnoughMana()
        }
    }
}