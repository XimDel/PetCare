package com.example.petcare.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petcare.R
import com.example.petcare.data.local.UsuarioDaoImpl
import com.example.petcare.ui.theme.navigation.Screen

@Preview(showBackground = true)
@Composable
fun VetLoginPage() {
    val navController = rememberNavController()
    VetLoginPage(navController = navController)
}

@Composable
fun VetLoginPage(navController: NavController) {
    var selectedRole by remember { mutableStateOf<String?>(null) }

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    var loginError by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.vet_background),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, start = 10.dp, end = 60.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(80.dp)
                        .padding(end = 12.dp)
                )
                Text(
                    text = "PetCare",
                    fontSize = 60.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF29978D),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Default
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.petcare_image_5),
                contentDescription = "petcare_image_5",
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomTextFieldsVLP(
                    username = username,
                    onUsernameChange = { username = it },
                    password = password,
                    onPasswordChange = { password = it }
                )
                RoleButtonVLP(
                    text = "Iniciar Sesión",
                    color = Color(0xFFFFFFFF),
                    isSelected = selectedRole == "Iniciar Sesión",
                    onClick = {navController.navigate(Screen.VetMainMenuScreen.route)}
                )
                if (loginError) {
                    Text(
                        text = "Credenciales incorrectas",
                        color = Color.Red,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextFieldsVLP(
    username: String,
    onUsernameChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit
) {
    OutlinedTextField(
        value = username,
        onValueChange = onUsernameChange,
        label = { Text("Usuario", fontSize = 20.sp, color = Color.White) },
        singleLine = true,
        textStyle = androidx.compose.ui.text.TextStyle(fontSize = 19.sp, color = Color.White),
        modifier = Modifier.fillMaxWidth(0.7f),
        shape = RoundedCornerShape(20.dp)
    )
    Spacer(modifier = Modifier.height(0.dp))
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = { Text("Contraseña", fontSize = 20.sp, color = Color.White) },
        singleLine = true,
        visualTransformation = PasswordVisualTransformation(),
        textStyle = androidx.compose.ui.text.TextStyle(fontSize = 19.sp, color = Color.White),
        modifier = Modifier.fillMaxWidth(0.7f),
        shape = RoundedCornerShape(20.dp)
    )
}


@Composable
fun RoleButtonVLP(
    text: String,
    color: Color,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .shadow(8.dp, shape = RoundedCornerShape(70.dp))
            .border(BorderStroke(2.dp, Color(0xFFA6CAEC)), RoundedCornerShape(70.dp))
            .background(color, RoundedCornerShape(70.dp))
            .clickable { onClick() }
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = text,
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF193148)
        )
    }
}
