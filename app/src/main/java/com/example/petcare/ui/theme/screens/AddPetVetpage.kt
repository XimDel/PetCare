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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.navigation.compose.rememberNavController
import com.example.petcare.R
import com.example.petcare.ui.theme.navigation.Screen

@Preview(showBackground = true)
@Composable
fun PreviewAddPetVetPage() {
    val navController = rememberNavController()
    AddPetVetPage(navController = navController)
}

@Composable
fun AddPetVetPage(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.backgroundvet),
            contentDescription = "Fondo registro veterinario",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 81.dp, start = 35.dp, end = 60.dp)
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
                    .clickable { navController.navigate(Screen.WelcomePage.route) }
            )
            Text(
                text = "PetCareVet",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF29978D),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Default
            )
        }
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 180.dp, start = 35.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.height(1.dp))
                RoleButtonFz(
                    navController = navController,
                    text = "Agregar Mascota existente",
                    color = Color(0xFFA4C8E1),
                    icon = R.drawable.peticonprincipal
                )


            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 510.dp, start = 35.dp)
                    .align(Alignment.TopCenter)
                    .clickable { navController.navigate(Screen.PetRegistry.route) },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                RoleButtonFy(
                    text = "Agregar Nueva Mascota",
                    color = Color(0xFFA4C8E1),
                    icon = R.drawable.peticonprincipal,
                    navController = navController

                )

            }

        }
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "home",
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
                .clickable { navController.navigate(Screen.VetMainMenuScreen.route) },
            tint = Color.White
        )

    }
}

@Composable
fun RoleButtonFy(
    navController: NavController,
    text: String,
    color: Color,
    icon: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .shadow(8.dp, shape = RoundedCornerShape(90.dp))
            .background(color, RoundedCornerShape(90.dp))
            .padding(40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = text,
            modifier = Modifier.size(70.dp)
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = text,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray

        )

    }
}

@Composable
fun RoleButtonFz(
    navController: NavController,
    text: String,
    color: Color,
    icon: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .shadow(8.dp, shape = RoundedCornerShape(90.dp))
            .background(color, RoundedCornerShape(90.dp))
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Icono y Texto en fila
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = text,
                modifier = Modifier
                    .size(90.dp) // Aumenta solo el icono
                    .clip(RoundedCornerShape(40)) // Mantiene bordes redondeados
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Text(
                text = text,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // **Fila para alinear los botones horizontalmente**
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Button(
                onClick = { navController.navigate(Screen.VetPetCodeScree.route) },
                modifier = Modifier
                    .weight(1f)
                    .border(2.dp, Color.Black, shape = RoundedCornerShape(50)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2A4D65),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Código")
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = {  navController.navigate(Screen.ScannerQRCodeScreen.route) },
                modifier = Modifier
                    .weight(1f)
                    .border(2.dp, Color.Black, shape = RoundedCornerShape(50)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2A4D65),
                    contentColor = Color.White
                )
            ) {
                Text(text = "QR")
            }
        }
    }
}