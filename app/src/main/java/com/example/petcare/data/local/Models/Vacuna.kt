package com.example.petcare.data.local

data class Vacuna(
    val idVacuna: Int,
    val idMascota: Int,
    val nombre: String,
    val fecha: String?
)