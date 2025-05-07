package com.example.petcare.data.local

import android.content.ContentValues
import android.content.Context

interface TipoMascotaDao {
    fun insertarTipoMascota(nombre: String): Long
    fun obtenerTiposMascota(): List<TipoMascota>
    fun actualizarTipoMascota(id: Int, nombre: String): Int
    fun eliminarTipoMascota(id: Int): Int
}

class TipoMascotaDaoImpl(private val context: Context) : TipoMascotaDao {
    override fun insertarTipoMascota(nombre: String): Long {
        val db = DBHelper(context).writableDatabase
        val values = ContentValues().apply {
            put("nombre", nombre)
        }
        val id = db.insert("tipo_mascota", null, values)
        db.close()
        return id
    }

    override fun obtenerTiposMascota(): List<TipoMascota> {
        val db = DBHelper(context).readableDatabase
        val cursor = db.query("tipo_mascota", null, null, null, null, null, null)
        val tipos = mutableListOf<TipoMascota>()
        with(cursor) {
            while (moveToNext()) {
                tipos.add(
                    TipoMascota(
                        getInt(getColumnIndexOrThrow("id_tipo_mascota")),
                        getString(getColumnIndexOrThrow("nombre"))
                    )
                )
            }
            close()
        }
        return tipos
    }

    override fun actualizarTipoMascota(id: Int, nombre: String): Int {
        val db = DBHelper(context).writableDatabase
        val values = ContentValues().apply {
            put("nombre", nombre)
        }
        val result = db.update("tipo_mascota", values, "id_tipo_mascota = ?", arrayOf(id.toString()))
        db.close()
        return result
    }

    override fun eliminarTipoMascota(id: Int): Int {
        val db = DBHelper(context).writableDatabase
        val result = db.delete("tipo_mascota", "id_tipo_mascota = ?", arrayOf(id.toString()))
        db.close()
        return result
    }
}