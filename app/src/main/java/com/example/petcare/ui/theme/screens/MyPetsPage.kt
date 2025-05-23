package com.example.petcare.ui.theme.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.petcare.R
import com.example.petcare.data.local.Mascota
import com.example.petcare.data.local.MascotaDaoImpl
import com.example.petcare.ui.theme.navigation.Screen

@Preview(showBackground = true)
@Composable
fun PreviewMyPetsPage() {
    val navController = rememberNavController()
    MyPetsPage(navController = navController)
}

@Composable
fun MyPetsPage(navController: NavHostController) {
    val context = LocalContext.current
    var mascotas by remember { mutableStateOf<List<Mascota>>(emptyList()) }

    LaunchedEffect(Unit) {
        val dao = MascotaDaoImpl(context)
        mascotas = dao.obtenerMascotas()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.mypets_background),
            contentDescription = "Fondo Mis Mascotas",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp, start = 20.dp, end = 20.dp, bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_home),
                    contentDescription = "Logo Izquierdo",
                    modifier = Modifier
                        .size(44.dp)
                        .clickable {
                            navController.navigate(
                                Screen.HomePetPage.createRoute(
                                    mascotas.firstOrNull()?.idMascota ?: 0
                                )
                            )
                        }
                )

                Text(
                    text = "Mis Mascotas",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF29978D),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Default,
                    modifier = Modifier.weight(1f)
                )

                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo Derecho",
                    modifier = Modifier
                        .size(54.dp))
            }

            // Tarjeta grande
            if (mascotas.isNotEmpty()) {
                PetCardLarge(
                    nombre = mascotas[0].nombre,
                    imageRes = R.drawable.mypets_pet_1,
                    onClick = {
                        navController.navigate(Screen.HomePetPage.createRoute(mascotas[0].idMascota))
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
            }

            // Tarjetas pequeñas
            val resto = mascotas.drop(1)
            val mascotasEnFilas = resto.chunked(2)

            mascotasEnFilas.forEach { fila ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    fila.forEach { mascota ->
                        PetCardSmall(
                            nombre = mascota.nombre,
                            imageRes = R.drawable.mypets_pet_2,
                            modifier = Modifier.weight(1f)
                        ) {
                            navController.navigate(Screen.HomePetPage.createRoute(mascota.idMascota))
                        }
                    }

                    // Si hay solo una mascota en la fila, rellena el espacio
                    if (fila.size == 1) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Botón fijo para agregar nueva mascota
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(Color(0xFF29978D))
                    .clickable { navController.navigate(Screen.PetRegistryNew.route) }
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar Mascota",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun PetCardLarge(
    nombre: String,
    imageRes: Int,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(3f / 2f)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .clickable { onClick() },
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Mascota grande",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White.copy(alpha = 0.8f))
        ) {
            Text(
                text = nombre,
                modifier = Modifier.padding(6.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun PetCardSmall(
    nombre: String,
    imageRes: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Mascota pequeña",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        Text(
            text = nombre,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(4.dp),
            textAlign = TextAlign.Center
        )
    }
}