package com.example.petcare.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petcare.R
import com.example.petcare.ui.theme.navigation.Screen

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewWelcomePage() {
    val navController = rememberNavController()
    WelcomePage(navController = navController)
}

@Composable
fun WelcomePage(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.inicio_background),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .clickable { navController.navigate(Screen.ProfileSelectionScreen.route)  }
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(300.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "PetCare",
                fontSize = 80.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF29978D),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Default
            )
        }
    }
}