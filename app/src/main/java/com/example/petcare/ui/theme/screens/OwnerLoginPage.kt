package com.example.petcare.ui.theme.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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
import com.example.petcare.data.local.inicializarUsuariosPorDefecto
import com.example.petcare.ui.theme.navigation.Screen

@Preview(showBackground = true)
@Composable
fun PreviewOwnerLoginPage() {
    val navController = rememberNavController()
    OwnerLoginPage(navController = navController)
}

@Composable
fun OwnerLoginPage(navController: NavController) {
    val context = LocalContext.current
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginError by remember { mutableStateOf(false) }

    // Insertar usuarios por defecto si no existen
    LaunchedEffect(Unit) {
        inicializarUsuariosPorDefecto(context)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo
        Image(
            painter = painterResource(id = R.drawable.inicio_background),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Cabecera con logo y título "PetCare"
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

        // Cuerpo
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.petcare_image_4),
                contentDescription = "petcare_image_4",
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(10.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomTextFields(
                    username = username,
                    onUsernameChange = { username = it },
                    password = password,
                    onPasswordChange = { password = it }
                )

                RoleButtonOLP(
                    text = "Iniciar Sesión",
                    color = Color(0xFFFFE599),
                    onClick = {
                        val dao = UsuarioDaoImpl(context)
                        val usuarios = dao.obtenerUsuarios()
                        val usuarioValido = usuarios.any {
                            it.correo == username.trim() && it.contrasenia == password.trim()
                        }

                        if (usuarioValido) {
                            navController.navigate(Screen.MyPetsPage.route)
                        } else {
                            loginError = true
                        }
                    }
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
fun CustomTextFields(
    username: String,
    onUsernameChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit
) {
    OutlinedTextField(
        value = username,
        onValueChange = onUsernameChange,
        label = { Text("Usuario", fontSize = 20.sp) },
        singleLine = true,
        textStyle = androidx.compose.ui.text.TextStyle(fontSize = 19.sp),
        modifier = Modifier.fillMaxWidth(0.7f),
        shape = RoundedCornerShape(20.dp)
    )
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = { Text("Contraseña", fontSize = 20.sp) },
        singleLine = true,
        visualTransformation = PasswordVisualTransformation(),
        textStyle = androidx.compose.ui.text.TextStyle(fontSize = 19.sp),
        modifier = Modifier.fillMaxWidth(0.7f),
        shape = RoundedCornerShape(20.dp)
    )
}

@Composable
fun RoleButtonOLP(
    text: String,
    color: Color,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .shadow(8.dp, shape = RoundedCornerShape(70.dp))
            .border(BorderStroke(2.dp, Color(0xFFE5D182)), RoundedCornerShape(70.dp))
            .background(color, RoundedCornerShape(70.dp))
            .clickable { onClick() }
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF746334)
        )
    }
}