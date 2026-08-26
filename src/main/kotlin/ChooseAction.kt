package org.example

fun chooseAction(character: Character, enemy: Enemy) {

    while (true) {
        println("Выберите действие:")
        println("1. Атаковать")
        println("2. Выпить зелье лечения")
        println("3. Выпить зелье маны")
        println("4. Использовать заклинание")

        when (readln().trim()) {
            "1" -> {
                character.attack(enemy)
                if (enemy.health > 0) {
                    enemy.attack(character)
                }
                return
            }
            "2" -> {
                character.drinkHealthPotion()
                return
            }
            "3" -> {
                character.drinkManaPotion()
                return
            }
            "4" -> {
                if (character is UseMagic) {
                    val spellWasCast = character.castSpell(enemy)
                    if (spellWasCast && enemy.health > 0) {
                        enemy.attack(character)
                    }
                } else {
                    println("Этот персонаж не умеет использовать заклинания")
                }
                return
            }
            else -> {
                println("Некорректный ввод. Введите 1, 2, 3 или 4")
            }
        }
    }

}