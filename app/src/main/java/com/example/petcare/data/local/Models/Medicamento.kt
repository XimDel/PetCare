package com.example.petcare.data.local

data class Medicamento(
    val idMedicamento: Int,
    val idMascota: Int,
    val nombre: String,
    val dosis: String?
)