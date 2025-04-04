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
import com.example.petcare.ui.theme.navigation.Screen

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewProfileSelectionScreen () {
    val navController = rememberNavController()
    ProfileSelectionScreen(navController = navController)
}

@Composable
fun ProfileSelectionScreen(navController: NavController) {
    var selectedRole by remember { mutableStateOf<String?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.inicio_background),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, start = 10.dp, end = 60.dp)
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            RoleButtonFS(
                text = "Propietario",
                color = Color(0xFFFFC1C1),
                icon = R.drawable.first_pet_icon,
                isSelected = selectedRole == "Propietario",
                onClick = {
                    selectedRole = "Propietario"
                    navController.navigate(Screen.OwnerStartPage.route)
                }
            )
            Spacer(modifier = Modifier.height(30.dp))
            RoleButtonFS(
                text = "Veterinario",
                color = Color(0xFFB0E0E6),
                icon = R.drawable.first_vet_icon,
                isSelected = selectedRole == "Veterinario",
                onClick = {
                    selectedRole = "Veterinario"
                    // Anadir cuando este veterinario screen
                }
            )
        }
    }
}

@Composable
fun RoleButtonFS(
    text: String,
    color: Color,
    icon: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .shadow(8.dp, shape = RoundedCornerShape(70.dp))
            .background(color, RoundedCornerShape(70.dp))
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
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = text,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray
        )
    }
}
