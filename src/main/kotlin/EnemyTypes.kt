package org.example

class Rat : Enemy(
    enemyName = "Крыса",
    health = 5,
    attackRate = 1,
    defenceRate = 1
)

class Kobold : Enemy(
    enemyName = "Кобольд",
    health = 8,
    attackRate = 2,
    defenceRate = 2
)

class Orc : Enemy(
    enemyName = "Орк",
    health = 12,
    attackRate = 3,
    defenceRate = 3
)

class Dragon : Enemy(
    enemyName = "Дракон",
    health = 20,
    attackRate = 5,
    defenceRate = 5
)