package org.example

class Warrior(name: String) : Character(
    name = name,
    characterClass = CharacterClass.Warrior,
    attackRate = 6,
    health = 20,
    mana = 0,
    inventory = Inventory(
        mapOf(
        HealthPotion to 2)
    )
) {

    override fun attack(enemy: Enemy) : Int {
        val damage = DamageCalculator.calculateDamage(attackRate, enemy.defenceRate)
        enemy.takeDamage(damage)

        return damage
    }

}

private const val SPELL_DAMAGE = 5
private const val MANA_COST = 1

class Mage(name: String) : Character(
    name = name,
    characterClass = CharacterClass.Mage,
    attackRate = 8,
    health = 10,
    mana = 3,
    inventory = Inventory(
        mapOf(
        HealthPotion to 1,
        ManaPotion to 2)
    )
), UseMagic {

    override fun castSpell(enemy: Enemy): Int? {

        if (mana >= MANA_COST) {
            mana -= MANA_COST
            enemy.takeDamage(SPELL_DAMAGE)

            return SPELL_DAMAGE
        } else {
            return null
        }
    }

    override fun attack(enemy: Enemy): Int {
        val damage = DamageCalculator.calculateDamage(attackRate, enemy.defenceRate)
        enemy.takeDamage(damage)

        return damage
    }

}

class Rogue(name: String) : Character(
    name = name,
    characterClass = CharacterClass.Rogue,
    attackRate = 10,
    health = 15,
    mana = 0,
    inventory = Inventory(
        mapOf(
        HealthPotion to 1)
    )
) {

    override fun attack(enemy: Enemy): Int {
        val damage = DamageCalculator.calculateDamage(attackRate, enemy.defenceRate)
        enemy.takeDamage(damage)

        return damage
    }

}