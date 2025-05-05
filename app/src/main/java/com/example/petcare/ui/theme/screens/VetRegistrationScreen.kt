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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Warning
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
import com.example.petcare.ui.theme.ThreeElementHeader

@Preview(showBackground = true)
@Composable
fun PreviewVetRegistrationPage() {
    val navController = rememberNavController()
    VetRegistrationScreen(navController = navController)
}

@Composable
fun VetRegistrationScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.vet_register_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Scaffold(
            topBar = {
                ThreeElementHeader(
                    firstIcon = R.drawable.house_icon,
                    firstContentDescription = "House icon",
                    firstText = stringResource(id = R.string.register_vet),
                    colorFirstText = Color(0xFF0d1925),
                    secondIcon = R.drawable.logo,
                    secondContentDescription = "Petcare icon",
                    useBoxForTitle = true,
                    onFirstIconClick = { navController.navigate(Screen.VetMainMenuScreen.route) },
                    onSecondIconClick = { navController.navigate(Screen.WelcomePage.route) }
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
                Box() { // Contenedor para la imagen y el QR
                    Image(
                        painter = painterResource(id = R.drawable.vet_code_image),
                        contentDescription = "vet photo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(top = 24.dp, bottom = 8.dp)
                            .size(350.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.vet_code_qr_image),
                        contentDescription = "Vet QR Code",
                        modifier = Modifier
                            .size(80.dp)
                            .align(Alignment.TopStart) // Lo posiciona arriba a la izquierda
                            .padding(top = 32.dp)
                            .clickable { navController.navigate(Screen.VetCodeScreen.route) }
                    )
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .wrapContentSize()
                        .shadow(4.dp, shape = RoundedCornerShape(4.dp))
                        .border(4.dp, Color(0xFF141e25), shape = RoundedCornerShape(4.dp))
                        .background(color = Color(0xFFc2e7e0))
                        .height(56.dp)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.register_vet_name),
                        textAlign = TextAlign.Center,
                        color = Color(0xFF0d1925),
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 28.sp,
                    )
                }
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box( // Contenedor para el "formulario" de registro
                        modifier = Modifier
                            .wrapContentHeight()
                            .padding(5.dp)
                            .border(2.dp, Color(0xFF999999), shape = RoundedCornerShape(4.dp))
                            .background(color = Color.White, shape = RoundedCornerShape(4.dp))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .align(Alignment.Center),
                            verticalArrangement = Arrangement.spacedBy(0.5.dp), // Espaciado uniforme entre las filas
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            VetRegistrationRow(
                                containerText = "Veterinario",
                                textValue = "Dato BD"
                            )
                            VetRegistrationRow(
                                containerText = "Dirección",
                                textValue = "Dato BD"
                            )
                            VetRegistrationRow(
                                containerText = "Email",
                                containerIcon = Icons.Default.Email,
                                textValue = "Nombre del Veterinario"
                            )
                            VetRegistrationRow(
                                containerText = "Teléfono",
                                containerIcon = Icons.Default.Phone,
                                textValue = "Nombre del Veterinario"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun VetRegistrationRow(
    containerText: String,
    containerIcon: ImageVector? = null,
    textValue: String? = null,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .padding(4.dp)
    ) {
        //VetRegistrationBox(containerBoxText = containerText)
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(1f)
                .shadow(2.dp, shape = RoundedCornerShape(4.dp))
                .border(4.dp, Color(0xFF8fb3ae), shape = RoundedCornerShape(4.dp))
                .height(42.dp)
        ) {
            Text(
                text = containerText,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF0d1925),
                fontSize = 24.sp
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(1f)
                .shadow(2.dp, shape = RoundedCornerShape(4.dp))
                .border(4.dp, Color(0xFF8fb3ae), shape = RoundedCornerShape(4.dp))
                .height(42.dp)
        ) {
            if (textValue != null && containerIcon == null) {
                Text(
                    text = textValue,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF0d1925),
                    fontSize = 12.sp
                )
            } else {
                Icon(
                    imageVector = containerIcon ?: Icons.Default.Warning,
                    contentDescription = "container icon",
                    tint = Color(0xFF193248),
                    modifier = Modifier.size(36.dp)
                )
            }
        }
    }
}