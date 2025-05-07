package com.example.petcare.data.local

import android.content.ContentValues
import android.content.Context

interface VacunaDao {
    fun insertarVacuna(idMascota: Int, nombre: String, fecha: String?): Long
    fun obtenerVacunas(): List<Vacuna>
    fun eliminarVacuna(id: Int): Int
}

class VacunaDaoImpl(private val context: Context) : VacunaDao {
    override fun insertarVacuna(idMascota: Int, nombre: String, fecha: String?): Long {
        val db = DBHelper(context).writableDatabase
        val values = ContentValues().apply {
            put("id_mascota", idMascota)
            put("nombre", nombre)
            put("fecha", fecha)
        }
        val id = db.insert("vacuna", null, values)
        db.close()
        return id
    }

    override fun obtenerVacunas(): List<Vacuna> {
        val db = DBHelper(context).readableDatabase
        val cursor = db.query("vacuna", null, null, null, null, null, null)
        val vacunas = mutableListOf<Vacuna>()
        with(cursor) {
            while (moveToNext()) {
                vacunas.add(
                    Vacuna(
                        getInt(getColumnIndexOrThrow("id_vacuna")),
                        getInt(getColumnIndexOrThrow("id_mascota")),
                        getString(getColumnIndexOrThrow("nombre")),
                        getString(getColumnIndexOrThrow("fecha"))
                    )
                )
            }
            close()
        }
        return vacunas
    }

    override fun eliminarVacuna(id: Int): Int {
        val db = DBHelper(context).writableDatabase
        val result = db.delete("vacuna", "id_vacuna = ?", arrayOf(id.toString()))
        db.close()
        return result
    }
}