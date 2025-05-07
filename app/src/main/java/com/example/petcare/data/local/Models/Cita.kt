package com.example.petcare.data.local

data class Cita(
    val idCita: Int,
    val idMascota: Int,
    val idTipoCita: Int,
    val fecha: String,
    val descripcion: String?
)