package com.example.petcare.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petcare.R

@OptIn(ExperimentalMaterial3Api::class) // Anotación para usar Scaffold con ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun BlogPostScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.blog_icon),
                            contentDescription = "Blog logo",
                            modifier = Modifier
                                .size(48.dp)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            text = "Blog de Salud",
                            textAlign = TextAlign.Center,
                            color = Color(0xFF7555a7),
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Bold,
                            fontSize = 40.sp,
                            modifier = Modifier.wrapContentWidth()
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "Petcare logo",
                            modifier = Modifier
                                .size(48.dp)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            item {
                BlogHorizontalDivider()
            }

            item {
                Image(
                    painter = painterResource(id = R.drawable.health_blog_image),
                    contentDescription = "Blog image",
                    modifier = Modifier
                        .size(500.dp)
                        .padding(top = 16.dp, bottom = 16.dp)
                )
            }

            item {
                BlogHorizontalDivider()
            }

            item {
                Text(
                    text = stringResource(id = R.string.blog_text),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify,
                    color = Color(0xFF636363),
                    modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 16.dp)
                )
            }
        }
    }
}

@Composable
fun BlogHorizontalDivider() {
    HorizontalDivider(
        thickness = 4.dp,
        color = Color(0xFF7555a7),
        modifier = Modifier.fillMaxWidth(0.9f) //solo el 80% del ancho de la pantalla
    )
}