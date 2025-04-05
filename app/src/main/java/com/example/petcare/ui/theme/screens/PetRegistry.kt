package com.example.petcare.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petcare.R
import com.example.petcare.ui.theme.Screen

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPetRegistry() {
    val navController = rememberNavController()
    PetRegistry(navController = navController)
}

@Composable
fun PetRegistry(navController: NavController) {
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
                            modifier = Modifier.size(70.dp)
                        )
                        Text(
                            text = "Registro",
                            fontSize = 45.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF29978D),
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily.Default
                        )
                        Image(
                            painter = painterResource(id = R.drawable.home_icon),
                            contentDescription = "Home Icon",
                            modifier = Modifier.size(50.dp)
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
                        modifier = Modifier.fillMaxSize().zIndex(0f)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.vet_code_qr_image),
                        contentDescription = "qr_icon",
                        modifier = Modifier.zIndex(0f)
                            .size(50.dp)
                            .clickable { navController.navigate(Screen.PetQRCode.route) }
                    )
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .offset(y = (-5).dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDEFAFF))
                    ) {
                        Text(
                            text = "Nombre",
                            fontSize = 25.sp,
                            color = Color(0xFF29978D),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                PetRegistryForm()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetRegistryForm() {
    var edad by remember { mutableStateOf(TextFieldValue("3")) }
    var peso by remember { mutableStateOf(TextFieldValue("5")) }
    var isDogSelected by remember { mutableStateOf(true) }
    var isCatSelected by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .shadow(8.dp, shape = RoundedCornerShape(12.dp))
                .border(
                    BorderStroke(2.dp, Color(0xFFE1CEC8)),
                    shape = RoundedCornerShape(12.dp)
                )
                .background(Color(0xFFFFF2EB), shape = RoundedCornerShape(12.dp))
                .padding(10.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(13.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Edad",
                        fontSize = 25.sp,
                        color = Color(0xFF000000),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = edad,
                        onValueChange = { edad = it },
                        modifier = Modifier.weight(1f),
                        singleLine = true,
                        shape = RoundedCornerShape(20.dp),
                        textStyle = LocalTextStyle.current.copy(fontSize = 20.sp),
                        label = { Text("Años",fontSize = 18.sp) },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFFFFFFFF),
                            unfocusedBorderColor = Color(0xFFFFFFFF),
                            cursorColor = Color(0xFFFFFFFF),
                            containerColor = Color(0xFFC1DDFD)
                        )
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Raza",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    Row(
                        modifier = Modifier.weight(1f),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        //Perro
                        Image(
                            painter = painterResource(id = R.drawable.ic_dog),
                            contentDescription = "Dog Icon",
                            modifier = Modifier
                                .size(55.dp)
                                .clickable {
                                    isDogSelected = true
                                    isCatSelected = false
                                }
                                .background(
                                    if (isDogSelected) Color(0xFFC1DDFD) else Color.Transparent,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .padding(5.dp)
                        )
                        //Gato
                        Image(
                            painter = painterResource(id = R.drawable.ic_cat),
                            contentDescription = "Cat Icon",
                            modifier = Modifier
                                .size(55.dp)
                                .clickable {
                                    isCatSelected = true
                                    isDogSelected = false
                                }
                                .background(
                                    if (isCatSelected) Color(0xFFC1DDFD) else Color.Transparent,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .padding(5.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Peso",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = peso,
                        onValueChange = { peso = it },
                        modifier = Modifier.weight(1f),
                        singleLine = true,
                        shape = RoundedCornerShape(20.dp),
                        textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
                        label = { Text("Kg",fontSize = 18.sp) },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFFFFFFFF),
                            unfocusedBorderColor = Color(0xFFFFFFFF),
                            cursorColor = Color(0xFFFFFFFF),
                            containerColor = Color(0xFFC1DDFD)
                        )
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Imágenes",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_cam),
                        contentDescription = "Camera Icon",
                        modifier = Modifier
                            .size(40.dp)
                            .weight(1f)
                            .clickable {
                                //Acción
                            },
                        alignment = Alignment.Center
                    )
                }
            }
        }
    }
}