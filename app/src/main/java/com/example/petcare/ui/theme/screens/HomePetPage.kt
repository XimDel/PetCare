package com.example.petcare.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petcare.R

@Preview(showBackground = true)
@Composable
fun HomeScreen() {

    val petName = "Nombre"

    Box(modifier = Modifier.fillMaxSize()) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.home_page_background),
            contentDescription = "Fondo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 42.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .background(
                        color = Color(0xFFE0F7FA),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Text(
                        text = "Bienvenido",
                        fontSize = 48.sp,
                        color = Color(0xFF333333),
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = "PetCare",
                        fontSize = 52.sp,
                        color = Color(0xFF29978D),
                        fontWeight = FontWeight.Bold
                    )
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(y = 96.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.homepage_pet),
                            contentDescription = "Mascota",
                            modifier = Modifier.size(210.dp)
                        )
                        Box(
                            modifier = Modifier
                                .background(Color.White, shape = RoundedCornerShape(8.dp))
                                .padding(horizontal = 12.dp, vertical = 8.dp)
                        ) {
                            Text(
                                text = petName,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.DarkGray
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(120.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                HomeOption(icon = R.drawable.homepage_register, label = "Registro")
                HomeOption(icon = R.drawable.homepage_history, label = "Historial")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                HomeOption(icon = R.drawable.homepage_calendar, label = "Calendario")
                HomeOption(icon = R.drawable.homepage_blog, label = "Blog")
            }

            Spacer(modifier = Modifier.height(80.dp))

            // Íconos inferiores
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                IconButton(R.drawable.logo_home)
                IconButton(R.drawable.logo)
                IconButton(R.drawable.logo_settings)
            }
        }
    }
}

@Composable
fun HomeOption(icon: Int, label: String) {
    Box(
        modifier = Modifier
            .size(140.dp)
            .clip(RoundedCornerShape(34.dp))
            .background(Color(0xFFE0F7FA))
    ) {

        Image(
            painter = painterResource(id = icon),
            contentDescription = label,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 16.dp)
                .size(72.dp)
        )

        Text(
            text = label,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .padding(horizontal = 12.dp, vertical = 2.dp)
        )
    }
}

@Composable
fun IconButton(icon: Int) {
    Image(
        painter = painterResource(id = icon),
        contentDescription = "Botón inferior",
        modifier = Modifier.size(50.dp)
    )
}
