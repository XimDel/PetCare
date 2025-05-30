package com.example.petcare.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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

@Preview(showBackground = true)
@Composable
fun PreviewVetRegisterPage() {
    val navController = rememberNavController()
    PetCodePageV(navController = navController)
}

@Composable
fun PetCodePageV(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.backgroundvet),
            contentDescription = "Fondo registro veterinario",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 81.dp, start = 35.dp, end = 60.dp)
                .align(Alignment.TopCenter),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(80.dp)
                    .padding(end = 12.dp)
            )
            Text(
                text = "PetCare",
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF29978D),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Default
            )
        }
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                RoleButtonFc(
                    text = "Ver datos del Veterinario",
                    color = Color(0xFFA4C8E1),
                    icon = R.drawable.first_vet_icon,
                    onClick = {
                        navController.navigate(Screen.VetRegistrationPage.route)
                    }
                )
            }

            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "home",
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 20.dp)
                    .clickable { navController.navigate(Screen.VetStartPage.route) },
                tint = Color.White
            )
        }

    }
}

@Composable
fun RoleButtonFc(
    text: String,
    color: Color,
    icon: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .shadow(8.dp, shape = RoundedCornerShape(90.dp))
            .background(color, RoundedCornerShape(90.dp))
            .clickable { onClick() }
            .padding(40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = text,
            modifier = Modifier.size(70.dp)
        )
        Spacer(modifier = Modifier.padding(3.dp))
        Text(
            text = text,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray
        )
    }
}

@Composable
fun RoleButtonFd(
    text: String,
    color: Color,
    icon: Int,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .shadow(8.dp, shape = RoundedCornerShape(90.dp))
            .background(color, RoundedCornerShape(90.dp))
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = text,
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(40))
            )
            Spacer(modifier = Modifier.padding(1.dp))
            Text(
                text = text,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

    }
}
