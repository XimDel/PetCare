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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.petcare.R
import com.example.petcare.ui.theme.navigation.Screen

@Preview(showBackground = true)
@Composable
fun PreviewPetHistoryPage() {
    val navController = rememberNavController()
    PetHistoryPage(navController = navController)
}

@Composable
fun PetHistoryPage(navController: NavController) {
    // Contenedor principal que ocupa todo el tamaño de la pantalla

    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo completo
        Image(
            painter = painterResource(id = R.drawable.pet_history_background),
            contentDescription = "Fondo Historial",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Imagen de la mascota (mitad hacia arriba)
        Image(
            painter = painterResource(id = R.drawable.pet_history_selected),
            contentDescription = "Mascota Historial",
            modifier = Modifier
                .fillMaxWidth()
                .height(420.dp)
                .offset(y = (-20).dp)
                .align(Alignment.TopCenter),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp, start = 20.dp, end = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Titulo principal y logos
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_home),
                    contentDescription = "Logo Izquierdo",
                    modifier = Modifier
                        .size(44.dp)
                        .clickable { navController.navigate(Screen.HomePetPage.route) }
                )

                Text(
                    text = "Historial",
                    fontSize = 48.sp,
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
                        .size(54.dp)
                )
            }

            Spacer(modifier = Modifier.height(240.dp))
            PetHistoryDetails( navController = navController)
        }
    }
}

@Composable
fun PetHistoryDetails(navController: NavController) {
    // Columna principal que organiza los elementos verticalmente

    Column(
        modifier = Modifier.fillMaxWidth()// La columna ocupa todo el ancho disponible
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (18).dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(88.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Color.White)
                    .border(3.dp, Color.White, RoundedCornerShape(50)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pet_history_selected),
                    contentDescription = "Avatar Mascota",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(88.dp)
                        .clip(RoundedCornerShape(50))
                        .clickable { navController.navigate(Screen.HomePetPage.route) }
                )

            }
        }

        Text(
            text = "Dato BD",
            fontWeight = FontWeight.Bold,
            fontSize = 52.sp,
            color = Color(0xFF444444),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp, bottom = 18.dp)
        )

        // Opciones del historial
        Column(
            verticalArrangement = Arrangement.spacedBy(18.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            HistoryOptionItem("📅", "Citas")
            HistoryOptionItem("💉", "Vacunas")
            HistoryOptionItem("💊", "Medicamentos")
            HistoryOptionItem("🩺", "Tratamientos")
        }
    }
}


@Composable
fun HistoryOptionItem(icon: String, label: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp, RoundedCornerShape(16.dp))
            .background(Color.White, RoundedCornerShape(12.dp))
            .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
            .padding(horizontal = 18.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = icon,
            fontSize = 27.sp
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = label,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium
        )
    }
}
