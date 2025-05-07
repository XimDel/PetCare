package com.example.petcare.data.local

import android.content.ContentValues
import android.content.Context

interface CitaDao {
    fun insertarCita(idMascota: Int, idTipoCita: Int, fecha: String, descripcion: String?): Long
    fun obtenerCitas(): List<Cita>
    fun eliminarCita(id: Int): Int
}

class CitaDaoImpl(private val context: Context) : CitaDao {
    override fun insertarCita(idMascota: Int, idTipoCita: Int, fecha: String, descripcion: String?): Long {
        val db = DBHelper(context).writableDatabase
        val values = ContentValues().apply {
            put("id_mascota", idMascota)
            put("id_tipo_cita", idTipoCita)
            put("fecha", fecha)
            put("descripcion", descripcion)
        }
        val id = db.insert("cita", null, values)
        db.close()
        return id
    }

    override fun obtenerCitas(): List<Cita> {
        val db = DBHelper(context).readableDatabase
        val cursor = db.query("cita", null, null, null, null, null, null)
        val citas = mutableListOf<Cita>()
        with(cursor) {
            while (moveToNext()) {
                citas.add(
                    Cita(
                        getInt(getColumnIndexOrThrow("id_cita")),
                        getInt(getColumnIndexOrThrow("id_mascota")),
                        getInt(getColumnIndexOrThrow("id_tipo_cita")),
                        getString(getColumnIndexOrThrow("fecha")),
                        getString(getColumnIndexOrThrow("descripcion"))
                    )
                )
            }
            close()
        }
        return citas
    }

    override fun eliminarCita(id: Int): Int {
        val db = DBHelper(context).writableDatabase
        val result = db.delete("cita", "id_cita = ?", arrayOf(id.toString()))
        db.close()
        return result
    }
}