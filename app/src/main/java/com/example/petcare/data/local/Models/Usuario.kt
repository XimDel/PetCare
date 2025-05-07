package com.example.petcare.data.local

data class Usuario(
    val idUsuario: Int,
    val nombre: String,
    val correo: String?,
    val contrasenia: String,
    val idTipoUsuario: Int
)