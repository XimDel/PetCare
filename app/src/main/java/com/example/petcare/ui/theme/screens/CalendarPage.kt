package com.example.petcare.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.petcare.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCalendarPage() {
    val navController = rememberNavController()
    CalendarPage(navController = navController)
}

@Composable
fun CalendarPage(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo
        Image(
            painter = painterResource(id = R.drawable.calendar_background),
            contentDescription = "Fondo Calendario",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título y logos
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_home),
                    contentDescription = "Logo Home",
                    modifier = Modifier.size(44.dp)
                )

                Text(
                    text = "Calendario",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF29978D),
                    fontFamily = FontFamily.Default
                )

                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo App",
                    modifier = Modifier.size(54.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "PET CARE",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3366CC)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Imagen del calendario visual
            Image(
                painter = painterResource(id = R.drawable.calendar),
                contentDescription = "Calendario Visual",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(340.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, top = 8.dp, bottom = 16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                LegendItem(color = Color(0xFF4ED6E6), text = "Citas Atendidas")
                LegendItem(color = Color(0xFFBDA9F3), text = "Citas Futuras")
                LegendItem(color = Color(0xFFF197F2), text = "Recordatorio")
            }

            Spacer(modifier = Modifier.weight(1f))

            // Menú inferior
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                IconPlaceholder(R.drawable.mypets_pet_3)
                IconPlaceholder(R.drawable.logo_add)
                IconPlaceholder(R.drawable.logo_reminder)
                IconPlaceholder(R.drawable.logo_search)
            }
        }
    }
}

@Composable
fun LegendItem(color: Color, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 2.dp)
    ) {
        Box(
            modifier = Modifier
                .size(18.dp)
                .background(color, RoundedCornerShape(50))
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
    }
}

@Composable
fun IconPlaceholder(iconRes: Int) {
    Image(
        painter = painterResource(id = iconRes),
        contentDescription = "Icono menú",
        modifier = Modifier.size(64.dp)
    )
}
