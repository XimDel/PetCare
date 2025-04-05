package com.example.petcare.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.petcare.ui.theme.screens.BlogPostScreen
import com.example.petcare.ui.theme.screens.CalendarPage
import com.example.petcare.ui.theme.screens.HealthBlogPage
import com.example.petcare.ui.theme.screens.HomeScreen
import com.example.petcare.ui.theme.screens.ProfileSelectionScreen
import com.example.petcare.ui.theme.screens.WelcomePage
import com.example.petcare.ui.theme.screens.OwnerStartPage
import com.example.petcare.ui.theme.screens.OwnerLoginPage
import com.example.petcare.ui.theme.screens.VetLoginPage
import com.example.petcare.ui.theme.screens.VetStartPage
import com.example.petcare.ui.theme.screens.MyPetsPage
import com.example.petcare.ui.theme.screens.PetCodePage
import com.example.petcare.ui.theme.screens.PetCodePageP
import com.example.petcare.ui.theme.screens.PetCodePageV
import com.example.petcare.ui.theme.screens.PetHistoryPage
import com.example.petcare.ui.theme.screens.PetHistoryVet
import com.example.petcare.ui.theme.screens.PetProfileScreen
import com.example.petcare.ui.theme.screens.PetQRCode
import com.example.petcare.ui.theme.screens.PetRegistry
import com.example.petcare.ui.theme.screens.ScannerQRCodeScreen
import com.example.petcare.ui.theme.screens.SearchPetScreen
import com.example.petcare.ui.theme.screens.VetCodeScreen
import com.example.petcare.ui.theme.screens.VetMainMenuScreen
import com.example.petcare.ui.theme.screens.VetRegistrationScreen
import com.example.petcare.ui.theme.screens.ViePetVet

sealed class Screen(val route: String) {
    object WelcomePage : Screen("welcomepage")
    object ProfileSelectionScreen : Screen("profileselectionscree")
    object OwnerStartPage : Screen("ownerstartpage")
    object OwnerLoginPage : Screen("ownerloginpage")
    object VetStartPage : Screen("vetstartpage")
    object VetLoginPage : Screen("vetloginpage")
    object MyPetsPage : Screen("mypetspage")
    object HomePetPage : Screen("homepetpage")
    object PetRegistry : Screen("petregistry")
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
        composable(Screen.HomePetPage.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.PetRegistry.route) {
            PetRegistry(navController = navController)
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
            PetCodePageP(navController = navController)
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
    }
}
