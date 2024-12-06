package com.example.zooapp.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zooapp.screens.AnimalScreen
import com.example.zooapp.screens.HomeScreen
import com.example.zooapp.models.charactersLists

@ExperimentalMaterial3Api
@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onAnimalSelected = { animal ->
                navController.navigate("animal/${animal.name}")
            })
        }
        composable("animal/{animal}") { backStackEntry ->
            val animalName = backStackEntry.arguments?.getString("animal")
            val selectedAnimal = charactersLists.first { it.name == animalName }
            AnimalScreen(selectedAnimal)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun NavGraphPreview(){
    NavGraph()
}
