package com.example.petcare.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.petcare.ui.theme.screens.BlogPostScreen
import com.example.petcare.ui.theme.screens.HealthBlogPage
import com.example.petcare.ui.theme.screens.HomeScreen
import com.example.petcare.ui.theme.screens.MyPetsPage
import com.example.petcare.ui.theme.screens.OwnerLoginPage
import com.example.petcare.ui.theme.screens.OwnerStartPage
import com.example.petcare.ui.theme.screens.PetCodePage
import com.example.petcare.ui.theme.screens.PetCodePageV
import com.example.petcare.ui.theme.screens.PetRegistry
import com.example.petcare.ui.theme.screens.ProfileSelectionScreen
import com.example.petcare.ui.theme.screens.VetLoginPage
import com.example.petcare.ui.theme.screens.VetMainMenuScreen
import com.example.petcare.ui.theme.screens.VetRegistrationScreen
import com.example.petcare.ui.theme.screens.VetStartPage
import com.example.petcare.ui.theme.screens.WelcomePage

sealed class Screen(val route: String) {
    object WelcomePage : Screen("welcomepage")
    object ProfileSelectionScreen : Screen("profileselectionscree")
    object OwnerStartPage : Screen("ownerstartpage")
    object OwnerLoginPage : Screen("ownerloginpage")
    object VetStartPage : Screen("vetstartpage")
    object VetLoginPage : Screen("vetloginpage")
    object MyPetsPage : Screen("mypetspage")
    object HealthBlogPage : Screen("healthblogpage")
    object PetRegisterPage : Screen("petregisterpage")
    object BlogPostScreen : Screen("blogpostscreen")
    object VetRegisterPage : Screen("vetregisterpage")
    object VetRegistrationPage : Screen("vetregistrationpage")
    object VetMainMenuScreen : Screen("vetmainmenuscreen")
    object PetRegistryNew : Screen("petregistry")
    object HomePetPageNew : Screen("homepetpage")

    // RUTA CON PARÁMETRO
    object HomePetPage : Screen("homepetpage/{idMascota}") {
        fun createRoute(idMascota: Int) = "homepetpage/$idMascota"
    }

    object PetRegistry : Screen("petregistry/{idMascota}") {
        fun createRoute(idMascota: Int) = "petregistry/$idMascota"
    }
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
        composable(Screen.VetStartPage.route) {
            VetStartPage(navController = navController)
        }
        composable(Screen.VetLoginPage.route) {
            VetLoginPage(navController = navController)
        }
        composable(Screen.MyPetsPage.route) {
            MyPetsPage(navController = navController)
        }
        composable(Screen.HealthBlogPage.route) {
            HealthBlogPage(navController = navController)
        }
        composable(Screen.PetRegisterPage.route) {
            PetCodePage(navController = navController)
        }
        composable(Screen.BlogPostScreen.route) {
            BlogPostScreen(navController = navController)
        }
        composable(Screen.VetRegisterPage.route) {
            PetCodePageV(navController = navController)
        }
        composable(Screen.VetRegistrationPage.route) {
            VetRegistrationScreen(navController = navController)
        }
        composable(Screen.VetMainMenuScreen.route) {
            VetMainMenuScreen(navController = navController)
        }
        composable(Screen.HomePetPageNew.route) {
            HomeScreen(navController = navController, idMascota = 0)
        }

        //  Ruta dinámica con parametros
        composable(
            route = "homepetpage/{idMascota}",
            arguments = listOf(navArgument("idMascota") { type = NavType.IntType })
        ) { backStackEntry ->
            val idMascota = backStackEntry.arguments?.getInt("idMascota") ?: 0
            HomeScreen(navController = navController, idMascota = idMascota)
        }
        composable(Screen.PetRegistryNew.route) {
            PetRegistry(navController = navController, idMascota = 0)
        }
        composable(
            route = "petregistry/{idMascota}",
            arguments = listOf(navArgument("idMascota") { type = NavType.IntType })
        ) { backStackEntry ->
            val idMascota = backStackEntry.arguments?.getInt("idMascota") ?: 0
            PetRegistry(navController = navController, idMascota = idMascota)
        }
    }
}
