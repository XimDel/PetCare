package com.example.petcare.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.petcare.R
import com.example.petcare.ui.theme.ThreeElementHeader

@Preview(showBackground = true)
@Composable
fun PreviewVetPetCodeScreen() {
    val navController = rememberNavController()
    VetPetCodeScreen(navController = navController)
}

@Composable
fun VetPetCodeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.vet_register_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Scaffold(
            topBar = {
                ThreeElementHeader(
                    firstIcon = R.drawable.house_icon,
                    firstContentDescription = "House icon",
                    firstText = stringResource(id = R.string.vet_pet_qr_code),
                    colorFirstText = Color(0xFF0d1925),
                    secondIcon = R.drawable.logo,
                    secondContentDescription = "Petcare icon",
                    useBoxForTitle = true
                )
            },
            containerColor = Color.Transparent
        ) { innerPadding ->
            CodeScreenContent(
                firstImage = R.drawable.vet_pet_code_image,
                firstImageDescription = "pet photo",
                secondImage = R.drawable.vet_code_qr_image,
                secondImageDescription = "Vet pet QR Code",
                innerPadding = innerPadding
            )
        }
    }
}