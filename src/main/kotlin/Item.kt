package org.example

abstract class Item (
    val name: String
) {

    abstract fun applyEffect(character: Character)
}

object HealthPotion : Item(
    name = "Зелье лечения"
) {
    private const val HEAL_AMOUNT = 10

    override fun applyEffect(character: Character) {
        character.restoreHealth(HEAL_AMOUNT)
    }
}

object ManaPotion : Item(
    name = "Зелье маны"
) {
    private const val MANA_AMOUNT = 3

    override fun applyEffect(character: Character) {
        character.restoreMana(MANA_AMOUNT)
    }
}