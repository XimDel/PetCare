package com.example.petcare.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.petcare.ui.theme.screens.ProfileSelectionScreen
import com.example.petcare.ui.theme.screens.WelcomePage
import com.example.petcare.ui.theme.screens.OwnerStartPage
import com.example.petcare.ui.theme.screens.OwnerLoginPage

sealed class Screen(val route: String) {
    object WelcomePage : Screen("welcomepage")
    object ProfileSelectionScreen : Screen("profileselectionscree")
    object OwnerStartPage : Screen("ownerstartpage")
    object OwnerLoginPage : Screen("ownerloginpage")
    // anadir aqui mas pantallas para navegacion
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.WelcomePage.route) {
        composable(Screen.WelcomePage.route) {
            WelcomePage(navController = navController)
        }
        composable(Screen.ProfileSelectionScreen.route) {
            ProfileSelectionScreen(navController = navController)
        }
        composable(Screen.OwnerStartPage.route) {
            OwnerStartPage(navController = navController)
        }
        composable(Screen.OwnerLoginPage.route) {
            OwnerLoginPage(navController = navController)
        }
        // Colocar mas pantallas

    }
}
