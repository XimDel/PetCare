package com.example.petcare.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.petcare.R
import com.example.petcare.ui.theme.ThreeElementHeader
import com.example.petcare.ui.theme.navigation.Screen

@Preview(showBackground = true)
@Composable
fun PetHistoryScreenPreview() {
    val navController = rememberNavController()
    PetHistoryVet(navController = navController)
}

@Composable
fun PetHistoryVet(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.backgroundvet),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    navController.navigate(Screen.HomePetPage.route)
                },
        )
        Scaffold(
            topBar = {
                ThreeElementHeader(
                    firstIcon = R.drawable.house_icon,
                    firstContentDescription = "Home",
                    firstText = "PetCare Vet",
                    colorFirstText = Color(0xFF91d4cd),
                    secondIcon = R.drawable.logo,
                    secondContentDescription = "Vet Logo"
                )
            },
            containerColor = Color.Transparent
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                Row {
                    Spacer(modifier = Modifier.height(8.dp))

                    // Filtro Section
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .shadow(4.dp, RoundedCornerShape(16.dp))
                            .background(Color(0xFF36556a), shape = RoundedCornerShape(16.dp))
                            .padding(12.dp)
                    ) {
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Filtrar",
                            color = Color(0xFFF5f5dc),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Box(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .background(Color(0xFF91d4cd))
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Filtrar",
                                tint = Color(0xFF2A4D65),
                                modifier = Modifier.size(35.dp)
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .padding(12.dp)
                    ) {
                        //Spacer(modifier = Modifier.width(45.dp))
                        Box(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .background(Color(0xFFF5f5dc))
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Filtrar",
                                tint = Color(0xFF2A4D65),
                                modifier = Modifier.size(35.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Box(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .background(Color(0xFFF5f5dc))
                        ) {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = "Filtrar",
                                tint = Color(0xFF2A4D65),
                                modifier = Modifier.size(35.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Box(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .background(Color(0xFFF5f5dc))
                        ) {
                            Icon(
                                imageVector = Icons.Default.List,
                                contentDescription = "Filtrar",
                                tint = Color(0xFF2A4D65),
                                modifier = Modifier.size(35.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Box(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .background(Color(0xFFF5f5dc))
                        ) {
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Filtrar",
                                tint = Color(0xFF2A4D65),
                                modifier = Modifier.size(35.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = Color(0xFFF5f5dc),
                        modifier = Modifier.fillMaxWidth(0.9f)
                    )
                }

                // Lista de mascotas
                PetCard(
                    petImage = R.drawable.peticonprincipal,
                    petName = "ARTY",
                    breed = "Beagle",
                    type = "Perro",
                    lastVisit = "10/10/23",
                    nextVisit = "11/10/23",
                    navController = navController
                )

                PetCard(
                    petImage = R.drawable.mypets_pet_2,
                    petName = "MINA",
                    breed = "Criollo",
                    type = "Gato",
                    lastVisit = "10/10/23",
                    nextVisit = "11/10/23",
                    navController = navController
                )

                PetCard(
                    petImage = R.drawable.mypets_pet_1,
                    petName = "LUCKY",
                    breed = "Husky",
                    type = "Perro",
                    lastVisit = "10/10/23",
                    nextVisit = "11/10/23",
                    navController = navController
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = Color(0xFFF5f5dc),
                        modifier = Modifier.fillMaxWidth(0.9f)
                    )
                }
            }
        }
    }
}

@Composable
fun PetCard(
    petImage: Int,
    petName: String,
    breed: String,
    type: String,
    lastVisit: String,
    nextVisit: String,
    navController: NavHostController
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .shadow(4.dp, RoundedCornerShape(16.dp))
            .background(Color(0xFF36556a), shape = RoundedCornerShape(16.dp))
            .padding(12.dp)
    ) {
        Image(
            painter = painterResource(id = petImage),
            contentDescription = "Pet image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
                .background(Color.White, CircleShape)
        )
        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    navController.navigate(Screen.ViePetVet.route)
                }
        ) {
            Text(
                text = petName,
                color = Color(0xFF91d4cd),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$breed - $type",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Última cita: $lastVisit",
                color = Color.White,
                fontSize = 14.sp
            )
            Text(
                text = "Próxima cita: $nextVisit",
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}