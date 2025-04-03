package com.example.petcare.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.petcare.R
import com.example.petcare.ui.theme.Screen

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewVetStartPage() {
    val navController = rememberNavController()
    VetStartPage(navController = navController)
}

@Composable
fun VetStartPage(navController: NavController) {
    var selectedRole by remember { mutableStateOf<String?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.vet_background),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, start = 25.dp, end = 80.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
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
                    text = "PetCare Vet",
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFA6CAEC),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Default
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.petcare_image_5),
                contentDescription = "petcare_image_5",
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                RoleButtonVSP(
                    text = "Iniciar",
                    color = Color(0xFFFFFFFF),
                    isSelected = selectedRole == "Iniciar",
                    onClick = {
                        selectedRole = "Iniciar"
                        navController.navigate(Screen.VetLoginPage.route)
                    }
                )

                RoleButtonVSP(
                    text = "Registrarse",
                    color = Color(0xFFFFFFFF),
                    isSelected = selectedRole == "Registrarse",
                    onClick = {
                        selectedRole = "Registrarse"
                        // anadir navegacion a registro
                    }
                )
            }
        }
    }
}

@Composable
fun RoleButtonVSP(
    text: String,
    color: Color,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.7f)
            .shadow(8.dp, shape = RoundedCornerShape(70.dp))
            //.border(BorderStroke(2.dp, Color(0xFFFFE599)), RoundedCornerShape(70.dp)) anadir borde
            .background(color, RoundedCornerShape(70.dp))
            .clickable { onClick() }
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = text,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF193148)
        )
    }
}

