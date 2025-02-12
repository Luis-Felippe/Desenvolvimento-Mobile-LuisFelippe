package com.example.authapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.authapp.data.AuthRepository
import com.example.authapp.ui.theme.AuthAppTheme
import com.example.authapp.ui.view.ForgotPasswordScreen
import com.example.authapp.ui.view.HomeScreen
import com.example.authapp.ui.view.LoginScreen
import com.example.authapp.ui.view.RegisterScreen
import com.example.authapp.viewModel.AuthViewModel
import com.example.authapp.viewModel.AuthViewModelFactory

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            AuthAppTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = AuthRepository()
        val authViewModel = ViewModelProvider(this, AuthViewModelFactory(repository)).get(
            AuthViewModel::class.java)

        setContent {
            val navController: NavHostController = rememberNavController()

            NavHost(navController = navController, startDestination = "login") {
                composable("login") { LoginScreen(authViewModel, navController) }
                composable("register") { RegisterScreen(authViewModel, navController) }
                composable("forgotPassword") { ForgotPasswordScreen(authViewModel, navController) }
                composable("home") { HomeScreen(authViewModel, navController) }
            }
        }
    }
}
