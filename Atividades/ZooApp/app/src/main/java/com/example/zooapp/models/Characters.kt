package com.example.zooapp.models

import com.example.zooapp.R


data class Characters (
    val id: Int,
    val name: String,
    val origin: String,
    val imageRes: Int,
    val description: String,
    val curiosities: String,
    var isFavorite: Boolean = false
)

val charactersLists = listOf(
    Characters(
        id = 1,
        name = "Ekko",
        origin = "UnderCity - Vielas",
        imageRes = R.drawable.ekko,
        description = "Ekko mora nas Vielas e comanda um grupo de sobreviventes chamado FogoLumes.",
        curiosities = "(GOAT) Também é conhecido como little man."
    ),
    Characters(
        id = 2,
        name = "Singed",
        origin = "Undercity - Vielas",
        imageRes = R.drawable.singas,
        description = "Singed é um gênio louco da química, que revolucionou a nação de Zaun.",
        curiosities = "Fez atrocidades com muitos humanos para reviver a filha."
    ),
    Characters(
        id = 3,
        name = "Caitlyn",
        origin = "Piltover",
        imageRes = R.drawable.cait,
        description = "Filha de uma Conselheira do Governo de Piltover.",
        curiosities = "A cunhada matou a mãe dela."
    ),
    Characters(
        id = 4,
        name = "Viktor",
        origin = "Undercity - Vielas",
        imageRes = R.drawable.viktor,
        description = "Junte-se à Gloriosa Evolução.",
        curiosities = "Vive pela Gloriosa Evolução."
    ),
    Characters(
        id = 5,
        name = "Jinx",
        origin = "Undercity - Vielas",
        imageRes = R.drawable.jinx,
        description = "Jinx é uma doida maníaca por armas.",
        curiosities = "Desde pequena não bate bem da cabeça e também é conhecida como Powder."
    ),
)
