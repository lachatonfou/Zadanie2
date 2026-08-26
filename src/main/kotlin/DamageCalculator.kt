package org.example

object DamageCalculator {

    fun calculateDamage(
        attackRate: Int,
        defenceRate: Int
    ): Int {
        return (attackRate - defenceRate).coerceAtLeast(0)
    }

}