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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petcare.R
import com.example.petcare.ui.theme.navigation.Screen

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPetQRCode() {
    val navController = rememberNavController()
    PetQRCode(navController = navController)
}

@Composable
fun PetQRCode(navController: NavController) {
    var selectedRole by remember { mutableStateOf<String?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFEF8EC))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 25.dp)
                    .zIndex(1f),
                contentAlignment = Alignment.TopCenter
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFDEFAFF), shape = RoundedCornerShape(8.dp))
                        .padding(horizontal = 3.dp, vertical = 2.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "Logo",
                            modifier = Modifier
                                .size(70.dp)
                        )
                        Box(
                            modifier = Modifier
                                .background(color = Color(0xFF29978D), shape = RoundedCornerShape(10.dp))
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        ) {
                            Text(
                                text = "Dato BD",
                                fontSize = 25.sp,
                                color = Color(0xFFDEFAFF),
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.home_icon),
                            contentDescription = "Home Icon",
                            modifier = Modifier
                                .size(50.dp)
                                .clickable { navController.navigate(Screen.MyPetsPage.route) }
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(300.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.petcare_image_),
                        contentDescription = "petcare_image_6",
                        modifier = Modifier
                            .fillMaxSize()
                            .zIndex(0f)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                PetQRCodeBox()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetQRCodeBox() {
    val qrPainter = painterResource(id = R.drawable.vet_code_qr_image)
    //painterResource en backend debe contener el codigo autogenerado

    Box(
        modifier = Modifier
            .size(300.dp)
            .border(
                width = 2.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(10.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(0.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = qrPainter,
            contentDescription = "QR Code",
            modifier = Modifier.fillMaxSize()
        )
    }
}