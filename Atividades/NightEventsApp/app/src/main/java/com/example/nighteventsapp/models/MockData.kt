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
        imageRes = R.mipmap.gamenight_icon_foreground
    ),
)