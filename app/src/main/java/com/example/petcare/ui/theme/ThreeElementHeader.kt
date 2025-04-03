package com.example.petcare.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Función Composable para un encabezado con tres elementos (dos iconos y un título central)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThreeElementHeader(
    firstIcon: Int,
    firstContentDescription: String,
    firstText: String,
    colorFirstText: Color,
    secondIcon: Int,
    SecondContentDescription: String
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

                Text(
                    text = firstText,
                    textAlign = TextAlign.Center,
                    color = colorFirstText,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    modifier = Modifier.wrapContentWidth()
                )

                Spacer(modifier = Modifier.width(16.dp))

                Image(
                    painter = painterResource(id = secondIcon),
                    contentDescription = SecondContentDescription,
                    modifier = Modifier
                        .size(48.dp)
                )
            }
        }
    )
}