package com.example.nighteventsapp.models

import androidx.compose.runtime.mutableStateOf
import com.example.nighteventsapp.R


val eventList = listOf(
    Event(
        id = 1,
        title = "Conferência de Tecnologia 2024",
        description = "Tendências em tecnologia.",
        date = "2024-12-15",
        location = "Parque Tecnológico",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.mipmap.tecnology_icon_foreground
    ),
    Event(
        id = 2,
        title = "GameNight 2024",
        description = "Noite de Jogos na UFC - Quixadá.",
        date = "2024-12-15",
        location = "UFC - Quixadá",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.gamenighticon
    ),
    Event(
        id = 3,
        title = "GameDay 2024",
        description = "Dia de Jogos na UFC - Quixadá.",
        date = "2025-02-15",
        location = "UFC - Quixadá",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.gamedayicon
    ),
    Event(
        id = 4,
        title = "Encontros Universitários 2024",
        description = "Encontros destinados ao ensino e aprendizado entre alunos.",
        date = "2024-12-03",
        location = "UFC - Quixadá",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img4
    ),
    Event(
        id = 5,
        title = "Baile da Pantera",
        description = "Festa realizada pelos alunos da UFC.",
        date = "2025-01-16",
        location = "UFC - Quixadá",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img8
    ),
)