package org.example

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
            if (character is useMagic) {
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