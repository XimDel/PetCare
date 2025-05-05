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
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.petcare.R
import com.example.petcare.ui.theme.navigation.Screen

@Preview(showBackground = true)
@Composable
fun ViewPetVetPreview() {
    val navController = rememberNavController()
    ViePetVet(navController = navController)
}

@Composable
fun ViePetVet(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDEFAFF))
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // HEADER
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Home Icon
                Image(
                    painter = painterResource(id = R.drawable.logo_home),
                    contentDescription = "Home Icon",
                    modifier = Modifier.size(40.dp)
                        .clickable {
                            navController.navigate(Screen.VetMainMenuScreen.route)
                        },
                )

                // Título "Historial"
                Text(
                    text = "Historial",
                    fontSize = 36.sp,
                    color = Color(0xFF2A4D65),
                    fontWeight = FontWeight.Bold
                )

                // Icono Salud
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Health Icon",
                    modifier = Modifier
                        .size(48.dp)
                        .clickable {
                            navController.navigate(Screen.WelcomePage.route)
                        }
                )
            }

            // FOTO DE MASCOTA GRANDE
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.petcare_image_),
                    contentDescription = "Pet Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                // Avatar pequeño
                Image(
                    painter = painterResource(id = R.drawable.petcare_image_),
                    contentDescription = "Pet Avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .align(Alignment.BottomStart)
                        .offset(x = 16.dp, y = 35.dp)
                        .clip(CircleShape)
                        .background(Color.White, shape = CircleShape)
                        .border(2.dp, Color.White, shape = CircleShape)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // NOMBRE DE LA MASCOTA
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.White, RoundedCornerShape(8.dp))
                        .border(2.dp, Color(0xFF2A4D65), RoundedCornerShape(8.dp))
                        .padding(horizontal = 20.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = "Dato BD",
                        fontSize = 24.sp,
                        color = Color(0xFF2A4D65),
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))
            }

            Spacer(modifier = Modifier.height(20.dp))

            // FORMULARIO DATOS
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .shadow(4.dp, RoundedCornerShape(12.dp))
                    .background(Color(0xFFFAFAFA), RoundedCornerShape(12.dp))
                    .border(2.dp, Color(0xFFBFD9D7), RoundedCornerShape(12.dp))
                    .padding(16.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Citas
                    HistoryRow("Citas", R.drawable.homepage_calendar, "~~~~~~")
                    // Vacunas
                    HistoryRow("Vacunas", R.drawable.homepage_blog, "~~~~~~")
                    // Medicamentos
                    HistoryRow("Medicamentos", null, "~~~~~~")
                    // Tratamientos
                    HistoryRow("Tratamientos", null, "~~~~~~")
                }
            }
        }
    }
}

@Composable
fun HistoryRow(label: String, iconId: Int?, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .background(Color.White, RoundedCornerShape(8.dp))
                .border(2.dp, Color(0xFF2A4D65), RoundedCornerShape(8.dp))
                .width(150.dp)
                .height(40.dp)
                .padding(start = 8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxSize()
            ) {
                if (iconId != null) {
                    Image(
                        painter = painterResource(id = iconId),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                Text(
                    text = label,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2A4D65),
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(Color.White, RoundedCornerShape(8.dp))
                .border(2.dp, Color(0xFF2A4D65), RoundedCornerShape(8.dp))
                .width(150.dp)
                .height(40.dp)
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                color = Color(0xFF2A4D65),
                textAlign = TextAlign.Center
            )
        }
    }
}
