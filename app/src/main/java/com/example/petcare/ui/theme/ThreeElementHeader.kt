package com.example.petcare.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Función Composable para un encabezado con tres elementos (dos iconos y un título central)
@OptIn(ExperimentalMaterial3Api::class) // Anotación para habilitar características de Material 3
@Composable
fun ThreeElementHeader(
    firstIcon: Int,
    firstContentDescription: String,
    firstText: String,
    colorFirstText: Color,
    secondIcon: Int,
    secondContentDescription: String,
    useBoxForTitle: Boolean = false, // Parámetro para activar un contenedor central en caso de que sea necesario
    titleBackgroundColor: Color = Color(0xFFc2e7e0)
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent
        ),
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = firstIcon),
                    contentDescription = firstContentDescription,
                    modifier = Modifier
                        .size(48.dp)
                )

                Spacer(modifier = Modifier.width(16.dp))

                if (useBoxForTitle) {
                    Box(
                        modifier = Modifier
                            .padding(top = 8.dp) // Agrega espacio arriba para separarlo del borde superior
                            .shadow(4.dp, shape = RoundedCornerShape(4.dp))
                            .border(4.dp, Color(0xFF141e25), shape = RoundedCornerShape(4.dp))
                            .background(titleBackgroundColor)
                            .height(56.dp)
                            .padding(horizontal = 32.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = firstText,
                            textAlign = TextAlign.Center,
                            color = colorFirstText,
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 40.sp,
                            modifier = Modifier.wrapContentWidth()
                        )
                    }
                } else { // Si no se debe usar un contenedor central, se muestra el texto directamente
                    Text(
                        text = firstText,
                        textAlign = TextAlign.Center,
                        color = colorFirstText,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp,
                        modifier = Modifier.wrapContentWidth()
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Image(
                    painter = painterResource(id = secondIcon),
                    contentDescription = secondContentDescription,
                    modifier = Modifier
                        .size(48.dp)
                )
            }
        }
    )
}