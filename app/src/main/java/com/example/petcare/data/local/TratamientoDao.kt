package com.example.petcare.data.local

import android.content.ContentValues
import android.content.Context

interface TratamientoDao {
    fun insertarTratamiento(idMascota: Int, nombre: String): Long
    fun obtenerTratamientos(): List<Tratamiento>
    fun eliminarTratamiento(id: Int): Int
}

class TratamientoDaoImpl(private val context: Context) : TratamientoDao {
    override fun insertarTratamiento(idMascota: Int, nombre: String): Long {
        val db = DBHelper(context).writableDatabase
        val values = ContentValues().apply {
            put("id_mascota", idMascota)
            put("nombre", nombre)
        }
        val id = db.insert("tratamiento", null, values)
        db.close()
        return id
    }

    override fun obtenerTratamientos(): List<Tratamiento> {
        val db = DBHelper(context).readableDatabase
        val cursor = db.query("tratamiento", null, null, null, null, null, null)
        val tratamientos = mutableListOf<Tratamiento>()
        with(cursor) {
            while (moveToNext()) {
                tratamientos.add(
                    Tratamiento(
                        getInt(getColumnIndexOrThrow("id_tratamiento")),
                        getInt(getColumnIndexOrThrow("id_mascota")),
                        getString(getColumnIndexOrThrow("nombre"))
                    )
                )
            }
            close()
        }
        return tratamientos
    }

    override fun eliminarTratamiento(id: Int): Int {
        val db = DBHelper(context).writableDatabase
        val result = db.delete("tratamiento", "id_tratamiento = ?", arrayOf(id.toString()))
        db.close()
        return result
    }
}