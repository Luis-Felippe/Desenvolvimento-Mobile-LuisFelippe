package com.example.planetapp.models

import com.example.planetapp.R

data class Planet(
    val id: Int,
    val name: String,
    val type: String,
    val galaxy: String,
    val distanceFromSun: String,
    val diameter: String,
    val characteristics: String,
    val imageRes: Int,
    var isFavorite: Boolean = false
)

val planetList = listOf(
    Planet(
        id = 1,
        name = "Andromeda",
        type = "Spiral Galaxy",
        galaxy = "Andromeda itself",
        distanceFromSun = "2,5 million light years",
        diameter = "220.000 light years",
        characteristics = "A Galaxy with prominent spiral arms, a bright central bulge, and many satellite galaxies.",
        imageRes = R.drawable.andromeda
    ),
    Planet(
        id = 2,
        name = "Mercury",
        type = "Terrestrial",
        galaxy = "Milky Way",
        distanceFromSun = "57.9 million km",
        diameter = "4,879 km",
        characteristics = "Smallest planet, no atmosphere, extreme temperatures.",
        imageRes = R.drawable.mercurio
    ),
    Planet(
        id = 3,
        name = "Venus",
        type = "Terrestrial",
        galaxy = "Milky Way",
        distanceFromSun = "108.2 million km",
        diameter = "12,104 km",
        characteristics = "Hottest planet, thick atmosphere, volcanic activity.",
        imageRes = R.drawable.venus
    ),
    Planet(
        id = 4,
        name = "Earth",
        type = "Terrestrial",
        galaxy = "Milky Way",
        distanceFromSun = "149.6 million km",
        diameter = "12,742 km",
        characteristics = "Supports life, has water and atmosphere.",
        imageRes = R.drawable.terra
    ),
    Planet(
        id = 5,
        name = "Mars",
        type = "Terrestrial",
        galaxy = "Milky Way",
        distanceFromSun = "227.9 million km",
        diameter = "6,779 km",
        characteristics = "Known as the Red Planet, has the largest volcano.",
        imageRes = R.drawable.marte
    ),
    Planet(
        id = 6,
        name = "Jupiter",
        type = "Gas Giant",
        galaxy = "Milky Way",
        distanceFromSun = "778.3 million km",
        diameter = "139,820 km",
        characteristics = "Largest planet, has a Great Red Spot, many moons.",
        imageRes = R.drawable.jupiter
    ),
    Planet(
        id = 7,
        name = "Saturn",
        type = "Gas Giant",
        galaxy = "Milky Way",
        distanceFromSun = "1.43 billion km",
        diameter = "116,460 km",
        characteristics = "Famous for its ring system, second largest planet.",
        imageRes = R.drawable.saturno
    ),
    Planet(
        id = 8,
        name = "Uranus",
        type = "Ice Giant",
        galaxy = "Milky Way",
        distanceFromSun = "2.87 billion km",
        diameter = "50,724 km",
        characteristics = "Rotates on its side, has a faint ring system.",
        imageRes = R.drawable.urano
    ),
    Planet(
        id = 9,
        name = "Neptune",
        type = "Ice Giant",
        galaxy = "Milky Way",
        distanceFromSun = "4.5 billion km",
        diameter = "49,244 km",
        characteristics = "Furthest planet, has the strongest winds.",
        imageRes = R.drawable.netuno
    ),
    Planet(
        id = 10,
        name = "Pluto",
        type = "Dwarf Planet",
        galaxy = "Milky Way",
        distanceFromSun = "5.91 billion km",
        diameter = "2,377 km",
        characteristics = "Smallest, icy, classified as a dwarf planet.",
        imageRes = R.drawable.plutao
    )
)

