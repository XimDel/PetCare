package com.example.petcare.data.local

data class Mascota(
    val idMascota: Int,
    val idTipoMascota: Int,
    val idRaza: Int,
    val idPropietario: Int,
    val nombre: String,
    val edad: Int,
    val pesoKg: Int,
    val codigoQr: String
)