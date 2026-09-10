package org.example

class GamePrint {

    fun printChooseAction(){
        println("Выберите действие:")
        println("1. Атаковать")
        println("2. Выпить зелье лечения")
        println("3. Выпить зелье маны")
        println("4. Использовать заклинание")
    }

    fun printCreateCharacter() {
        println("Введите класс:")
        println("1. Warrior")
        println("2. Mage")
        println("3. Rogue")
    }

    fun printIncorrectInput() {
        println("Некорректный ввод")
    }

    fun printCharacterInfo(character: Character) {

        println("Персонаж создан")
        println("Имя: ${character.name}")
        println("Класс: ${character.characterClass}")
        println("Атака: ${character.attackRate}")
        println("Здоровье: ${character.health}")
        println("Мана: ${character.mana}")
        println("Инвентарь: ${character.inventory}")

    }

    fun printCannotUseMagic() {
        println("Этот персонаж не умеет использовать заклинания")
    }

    fun printSuccessfulUseItem(item: Item){
        println("Вы использовали ${item.name}")
    }

    fun printFailedUseItem(item: Item){
        println("Предмета ${item.name} нет в инвентаре")
    }

    fun printNotEnoughMana() {
        println("У вас недостаточно маны")
    }

    fun printInventory(character: Character){
        println("Ваш инвентарь: ${character.inventory}")
    }

    fun printCharacterDie() {
        println("Персонаж погиб. Игра окончена")
    }

    fun printGameVictory() {
        println("Все противники погибли. Вы победили!")
    }

    fun printCharacterHealth(character: Character) {
        println("Ваше здоровье: ${character.health}")
    }

    fun printCharacterMana(character: Character) {
        println("Ваша мана: ${character.mana}")
    }

    fun printCharacterAttacked(character: Character, enemy: Enemy, damage: Int) {
        println("${character.name} атакует ${enemy.enemyName}")
        println("Нанесено урона: $damage")
        println("Здоровье противника: ${enemy.health}")
    }

    fun printCharacterAttackedMagic(character: Character, enemy: Enemy, damage: Int) {
        println("${character.name} использует заклинание")
        println("Заклинание нанесло $damage урона")
        println("Осталось маны: ${character.mana}")
        println("Здоровье противника: ${enemy.health}")
    }

    fun printEnemyAppeared(enemy: Enemy) {
        println("Перед вами ${enemy.enemyName}")
        println("Атака противника: ${enemy.attackRate}")
        println("Здоровье противника: ${enemy.health}")
        println("Защита противника: ${enemy.defenceRate}")
    }

    fun printEnemyAttacked(character: Character, enemy: Enemy, damage: Int) {
        println("${enemy.enemyName} атакует в ответ")
        println("Противник нанес $damage урона")
        println("Ваше здоровье: ${character.health}")
    }

    fun printEnemyDie(enemy: Enemy) {
        println("${enemy.enemyName} побежден!")
    }

}