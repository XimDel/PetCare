package com.example.petcare.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlogPostScren(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Blog Salud",
                        textAlign = TextAlign.Center,
                        color = androidx.compose.ui.graphics.Color(0xFF8e71ea),
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Bold,
                        fontSize = 50.sp
                    )
                },
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Blog Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, end = 8.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text ="Texto del artículo completo",
                    modifier = Modifier.padding(16.dp)
                )

            }

        }
    }
}










@Preview(showBackground = true)
@Composable
fun BlogPostScrenPreview() {
    val navController = rememberNavController()
    BlogPostScren(navController = navController)
}