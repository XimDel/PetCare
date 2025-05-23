package com.example.petcare.ui.theme.screens

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.petcare.ui.theme.navigation.Screen

@Preview(showBackground = true)
@Composable
fun PreviewHealthBlogPage() {
    val navController = rememberNavController()
    HealthBlogPage(navController = navController)
}

@Composable
fun HealthBlogPage(navController: NavHostController) {
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
                    modifier = Modifier
                        .size(44.dp)
                        .clickable { navController.navigate(Screen.HomePetPage.route) }
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
                    modifier = Modifier
                        .size(54.dp))
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
                            .clickable { navController.navigate(Screen.BlogPostScreen.route) }
                        //modificar segun database de articulos
                    )
                    Image(
                        painter = painterResource(id = R.drawable.health_blog_carrusel_3),
                        contentDescription = "Portada 2",
                        modifier = Modifier
                            .size(width = 110.dp, height = 140.dp)
                            .padding(horizontal = 4.dp)
                            .clickable { navController.navigate(Screen.BlogPostScreen.route) }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.health_blog_carrusel_2),
                        contentDescription = "Portada 3",
                        modifier = Modifier
                            .size(width = 110.dp, height = 140.dp)
                            .padding(horizontal = 4.dp)
                            .clickable { navController.navigate(Screen.BlogPostScreen.route) }
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
