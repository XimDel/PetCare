package com.example.petcare.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petcare.R
import com.example.petcare.ui.theme.Screen
import com.example.petcare.ui.theme.ThreeElementHeader

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewVetCodeScreen() {
    val navController = rememberNavController()
    VetCodeScreen(navController = navController)
}

@Composable
fun VetCodeScreen(navController: NavController) {
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
                    firstText = stringResource(id = R.string.vet_qr_code),
                    colorFirstText = Color(0xFF0d1925),
                    secondIcon = R.drawable.logo,
                    secondContentDescription = "Petcare icon",
                    useBoxForTitle = true
                )
            },
            containerColor = Color.Transparent
        ) { innerPadding ->
            CodeScreenContent(
                firstImage = R.drawable.vet_code_image,
                firstImageDescription = "Vet photo",
                secondImage = R.drawable.vet_code_qr_image,
                secondImageDescription = "Vet QR Code",
                innerPadding = innerPadding
            )
        }
    }
}

@Composable
fun CodeScreenContent(
    firstImage: Int,
    firstImageDescription: String,
    secondImage: Int,
    secondImageDescription: String,
    innerPadding: PaddingValues
) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = firstImage),
            contentDescription = firstImageDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 24.dp)
                .size(370.dp)
                .align(Alignment.CenterHorizontally)
        )
        Image(
            painter = painterResource(id = secondImage),
            contentDescription = secondImageDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(12.dp)
                .size(300.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}