package org.example

class GameMaster {

    fun startGame() {
        val character = createCharacter()

        while (character.health > 0 && EnemyRepository.hasEnemies()) {
            val enemy = EnemyRepository.getNextEnemy()

            GamePrint.printEnemyAppeared(enemy)
            fight(character, enemy)
        }

        if (character.health <= 0) {
            GamePrint.printCharacterDie()
        } else {
            GamePrint.printGameVictory()
        }
    }

    private fun fight(character: Character, enemy: Enemy) {
        while (character.health > 0 && enemy.health > 0) {
            chooseAction(character, enemy)
        }

        if (enemy.health <= 0) {
            GamePrint.printEnemyDie(enemy)
        }
    }

    private fun chooseAction(character: Character, enemy: Enemy) {
        while (true) {
            GamePrint.printChooseAction()

            when (readln().trim()) {
                "1" -> return characterAttack(character, enemy)
                "2" -> return useItem(character, HealthPotion)
                "3" -> return useItem(character, ManaPotion)
                "4" -> return useMagic(character, enemy)
                else -> GamePrint.printIncorrectInput()
            }
        }
    }

    private fun characterAttack(character: Character, enemy: Enemy) {
        val damage = character.attack(enemy)

        GamePrint.printCharacterAttacked(character, enemy, damage)

        if (enemy.health > 0) {
            enemyAttack(enemy, character)
        }
    }

    private fun enemyAttack(enemy: Enemy, character: Character) {
        val damage = enemy.attack(character)

        GamePrint.printEnemyAttacked(character, enemy, damage)
    }

    private fun useItem(character: Character, item: Item) {
        val itemWasUsed = character.useItem(item)

        if (itemWasUsed) {
            GamePrint.printSuccessfulUseItem(item)
            GamePrint.printInventory(character)
            GamePrint.printCharacterHealth(character)
            GamePrint.printCharacterMana(character)
        } else {
            GamePrint.printFailedUseItem(item)
        }
    }

    private fun useMagic(character: Character, enemy: Enemy) {
        if (character !is UseMagic) {
            GamePrint.printCannotUseMagic()
            return
        }

        val damage = character.castSpell(enemy)

        if (damage != null) {
            GamePrint.printCharacterAttackedMagic(character, enemy, damage)

            if (enemy.health > 0) {
                enemyAttack(enemy, character)
            }
        } else {
            GamePrint.printNotEnoughMana()
        }
    }
}