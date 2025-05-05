package com.example.petcare.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petcare.R
import com.example.petcare.ui.theme.navigation.Screen
import com.example.petcare.ui.theme.ThreeElementHeader

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewVetMainMenuScreen() {
    val navController = rememberNavController()
    VetMainMenuScreen(navController = navController)
}

@Composable
fun VetMainMenuScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.vet_main_menu_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Scaffold(
            topBar = {
                ThreeElementHeader(
                    firstIcon = R.drawable.house_icon,
                    firstContentDescription = "House icon",
                    firstText = stringResource(id = R.string.petcare_vet),
                    colorFirstText = Color(0xFF91d4cd),
                    secondIcon = R.drawable.logo,
                    secondContentDescription = "Petcare icon",
                    onFirstIconClick = { navController.navigate(Screen.VetMainMenuScreen.route) },
                    onSecondIconClick = { navController.navigate(Screen.WelcomePage.route) },
                )
            },
            containerColor = Color.Transparent
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .shadow(8.dp, shape = RoundedCornerShape(16.dp))
                        .background(color = Color(0xFF36556a), shape = RoundedCornerShape(16.dp))
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = "Veterinaria",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.first_vet_icon),
                    contentDescription = "Veterinaria / Veterinario",
                    modifier = Modifier
                        .size(180.dp)
                        .align(Alignment.Start)
                        .offset(x = (50).dp) // Ajusta la imagen hacia el centro de forma horizontal
                        .offset(y = (24).dp) // Ajusta la imagen hacia abajo
                )
                // Cada botón navega a Screen.AQUIPANTALLA.route al hacer click
                VetMainMenuButton(
                    buttonIcon = Icons.Default.Add,
                    buttonText = "Agregar Mascota",
                    onClick = { navController.navigate(Screen.AddPetVetPage.route) }
                )
                VetMainMenuButton(
                    buttonIcon = Icons.Default.Search,
                    buttonText = "Ver Mascota",
                    onClick = { navController.navigate(Screen.SearchPetScreen.route) }
                )
                VetMainMenuButton(
                    buttonIcon = Icons.Default.Info,
                    buttonText = "Historial de Mascotas",
                    onClick = { navController.navigate(Screen.PetHistoryVet.route) }
                )

                Spacer(modifier = Modifier.height(24.dp))

               /* Image(
                    painter = painterResource(id = R.drawable.house_icon),
                    contentDescription = "House icon",
                    modifier = Modifier
                        .size(80.dp)
                        .align(Alignment.CenterHorizontally)
                )*/ // Boton duplicado "home", pendiente definir si queda o no
            }
        }
    }
}

// Función Composable para los botones del menú principal del veterinario
@Composable
fun VetMainMenuButton(
    buttonIcon: ImageVector,
    buttonText: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .clickable { onClick() }
            .shadow(8.dp, shape = RoundedCornerShape(24.dp))
            .background(Color(0xFFa8ccec), shape = RoundedCornerShape(60.dp))
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier.wrapContentWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = buttonIcon,
                contentDescription = "Icono de mascota",
                tint = Color(0xFF1b344a),
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = buttonText,
                textAlign = TextAlign.Center,
                color = Color(0xFF1b344a),
                fontSize = 42.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.wrapContentWidth()
            )
        }
    }
    Spacer(modifier = Modifier.height(24.dp))
}
