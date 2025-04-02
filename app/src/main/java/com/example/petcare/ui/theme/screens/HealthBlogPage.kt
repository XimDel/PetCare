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
import androidx.compose.ui.tooling.preview.Preview
import com.example.petcare.R
//import com.example.petcare.ui.theme.Screen

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HealthBlogPage() {
    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.health_background),
            contentDescription = "Fondo Blog de Salud",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Image(
                    painter = painterResource(id = R.drawable.logo_home),
                    contentDescription = "Logo Izquierdo",
                    modifier = Modifier.size(48.dp)
                )

                // Título
                Text(
                    text = "Blog De Salud",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF29978D),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Default,
                    modifier = Modifier.weight(1f)
                )

                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo Derecho",
                    modifier = Modifier.size(58.dp)
                )
            }


            Spacer(modifier = Modifier.height(32.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.arrow_left),
                    contentDescription = "Flecha Izquierda",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.health_blog_carrusel_1),
                        contentDescription = "Portada 1",
                        modifier = Modifier
                            .size(width = 110.dp, height = 140.dp)
                            .padding(horizontal = 4.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.health_blog_carrusel_3),
                        contentDescription = "Portada 2",
                        modifier = Modifier
                            .size(width = 110.dp, height = 140.dp)
                            .padding(horizontal = 4.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.heath_blog_carrusel_2),
                        contentDescription = "Portada 3",
                        modifier = Modifier
                            .size(width = 110.dp, height = 140.dp)
                            .padding(horizontal = 4.dp)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.arrow_right),
                    contentDescription = "Flecha Derecha",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}
