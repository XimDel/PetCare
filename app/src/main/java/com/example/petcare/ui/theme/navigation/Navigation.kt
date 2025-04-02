package com.example.petcare.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import com.example.petcare.WelcomePage

sealed class Screen(val route: String) {
    object WelcomePage : Screen("welcomepage")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.WelcomePage.route) {
        composable(Screen.WelcomePage.route) {
           // WelcomePage(navController = navController)
        }
    }
}