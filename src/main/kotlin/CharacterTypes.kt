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

private const val SPELLDAMAGE = 5
private const val MANACOST = 1

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

        if (mana >= MANACOST) {
            mana -= MANACOST
            enemy.takeDamage(SPELLDAMAGE)

            return SPELLDAMAGE
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