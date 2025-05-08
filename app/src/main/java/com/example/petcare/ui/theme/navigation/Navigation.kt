package com.example.petcare.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.petcare.ui.theme.screens.*

sealed class Screen(val route: String) {
    object WelcomePage : Screen("welcomepage")
    object ProfileSelectionScreen : Screen("profileselectionscree")
    object OwnerStartPage : Screen("ownerstartpage")
    object OwnerLoginPage : Screen("ownerloginpage")
    object VetStartPage : Screen("vetstartpage")
    object VetLoginPage : Screen("vetloginpage")
    object MyPetsPage : Screen("mypetspage")
    object PetHistoryPage : Screen("pethistorypage")
    object CalendarPage : Screen("calendarpage")
    object HealthBlogPage : Screen("healthblogpage")
    object PetQRCode : Screen("petqrcode")
    object PetRegisterPage : Screen("petregisterpage")
    object BlogPostScreen : Screen("blogpostscreen")
    object ScannerQRCodeScreen : Screen("scannerqrcodescreen")
    object VetRegisterPage : Screen("vetregisterpage")
    object VetRegistrationPage : Screen("vetregistrationpage")
    object VetCodeScreen : Screen("vetcodescreen")
    object VetMainMenuScreen : Screen("vetmainmenuscreen")
    object AddPetVetPage : Screen("addpetvetpage")
    object AddPetVet : Screen("addpetvet")
    object PetHistoryVet : Screen("pethistoryvet")
    object ViePetVet : Screen("viewpetvet")
    object SearchPetScreen : Screen("searchpetscreen")
    object VetPetCodeScree : Screen("vetpetcodescreen")
    object PetRegistryNew : Screen("petregistry")

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
        composable(Screen.PetHistoryPage.route) {
            PetHistoryPage(navController = navController)
        }
        composable(Screen.CalendarPage.route) {
            CalendarPage(navController = navController)
        }
        composable(Screen.HealthBlogPage.route) {
            HealthBlogPage(navController = navController)
        }
        composable(Screen.PetQRCode.route) {
            PetQRCode(navController = navController)
        }
        composable(Screen.PetRegisterPage.route) {
            PetCodePage(navController = navController)
        }
        composable(Screen.BlogPostScreen.route) {
            BlogPostScreen(navController = navController)
        }
        composable(Screen.ScannerQRCodeScreen.route) {
            ScannerQRCodeScreen(navController = navController)
        }
        composable(Screen.VetRegisterPage.route) {
            PetCodePageV(navController = navController)
        }
        composable(Screen.VetRegistrationPage.route) {
            VetRegistrationScreen(navController = navController)
        }
        composable(Screen.VetCodeScreen.route) {
            VetCodeScreen(navController = navController)
        }
        composable(Screen.VetMainMenuScreen.route) {
            VetMainMenuScreen(navController = navController)
        }
        composable(Screen.AddPetVetPage.route) {
            AddPetVetPage(navController = navController)
        }
        composable(Screen.AddPetVet.route) {
            PetProfileScreen(navController = navController)
        }
        composable(Screen.PetHistoryVet.route) {
            PetHistoryVet(navController = navController)
        }
        composable(Screen.ViePetVet.route) {
            ViePetVet(navController = navController)
        }
        composable(Screen.SearchPetScreen.route) {
            SearchPetScreen(navController = navController)
        }
        composable(Screen.VetPetCodeScree.route) {
            VetPetCodeScreen(navController = navController)
        }

        // ✅ Ruta dinámica con parámetro
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