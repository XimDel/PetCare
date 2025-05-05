package com.example.petcare.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petcare.R
import com.example.petcare.ui.theme.ThreeElementHeader
import com.example.petcare.ui.theme.navigation.Screen

@Preview(showBackground = true)
@Composable
fun PreviewScannerQRCodeScreen() {
    val navController = rememberNavController()
    ScannerQRCodeScreen(navController = navController)
}

@Composable
fun ScannerQRCodeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(color = 0xFF0E1F29))
    ) {
        Scaffold(
            topBar = {
                ThreeElementHeader(
                    firstIcon = R.drawable.house_icon,
                    firstContentDescription = "House icon",
                    firstText = stringResource(id = R.string.qr_code_scanner),
                    colorFirstText = Color(0xFF0d1925),
                    secondIcon = R.drawable.logo,
                    secondContentDescription = "Petcare icon",
                    useBoxForTitle = true,
                    //onFirstIconClick = { navController.navigate(Screen.HomePetPage.route) }, -- Pendiente definir la ruta del icono "home"
                    onSecondIconClick = { navController.navigate(Screen.WelcomePage.route) },
                )
            },
            containerColor = Color.Transparent
        ) { innerPadding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {

                Text(
                    text = stringResource(id = R.string.qr_code_scanner_message),
                    color = Color.White,
                    textAlign = TextAlign.Justify,
                    fontFamily = FontFamily.Default,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(alignment = Alignment.CenterHorizontally)
                )

                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .size(350.dp)
                        .border(4.dp, Color.White, RoundedCornerShape(16.dp))
                        .background(Color.Black.copy(alpha = 0.3f), RoundedCornerShape(16.dp))
                    // Simulación espacio de camara
                )
            }
        }
    }
}