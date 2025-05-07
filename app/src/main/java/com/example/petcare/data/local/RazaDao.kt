package com.example.petcare.data.local

import android.content.ContentValues
import android.content.Context

class RazaDaoImpl(private val context: Context) : RazaDao {

    override fun insertarRaza(idTipoMascota: Int): Long {
        val db = DBHelper(context).writableDatabase
        val values = ContentValues().apply {
            put("id_tipo_mascota", idTipoMascota)
        }
        val id = db.insert("raza", null, values)
        db.close()
        return id
    }

    override fun obtenerRazas(): List<Raza> {
        val db = DBHelper(context).readableDatabase
        val cursor = db.query("raza", null, null, null, null, null, null)
        val razas = mutableListOf<Raza>()
        with(cursor) {
            while (moveToNext()) {
                razas.add(
                    Raza(
                        getInt(getColumnIndexOrThrow("id_raza")),
                        getInt(getColumnIndexOrThrow("id_tipo_mascota"))
                    )
                )
            }
            close()
        }
        return razas
    }

    override fun actualizarRaza(id: Int, idTipoMascota: Int): Int {
        val db = DBHelper(context).writableDatabase
        val values = ContentValues().apply {
            put("id_tipo_mascota", idTipoMascota)
        }
        val result = db.update("raza", values, "id_raza = ?", arrayOf(id.toString()))
        db.close()
        return result
    }

    override fun eliminarRaza(id: Int): Int {
        val db = DBHelper(context).writableDatabase
        val result = db.delete("raza", "id_raza = ?", arrayOf(id.toString()))
        db.close()
        return result
    }
}

interface RazaDao {
    fun insertarRaza(idTipoMascota: Int): Long
    fun obtenerRazas(): List<Raza>
    fun actualizarRaza(id: Int, idTipoMascota: Int): Int
    fun eliminarRaza(id: Int): Int
}
