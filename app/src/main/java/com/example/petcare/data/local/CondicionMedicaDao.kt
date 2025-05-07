package com.example.petcare.data.local

import android.content.ContentValues
import android.content.Context

interface CondicionMedicaDao {
    fun insertarCondicion(idMascota: Int, nombre: String): Long
    fun obtenerCondiciones(): List<CondicionMedica>
    fun eliminarCondicion(id: Int): Int
}

class CondicionMedicaDaoImpl(private val context: Context) : CondicionMedicaDao {
    override fun insertarCondicion(idMascota: Int, nombre: String): Long {
        val db = DBHelper(context).writableDatabase
        val values = ContentValues().apply {
            put("id_mascota", idMascota)
            put("nombre", nombre)
        }
        val id = db.insert("condicion_medica", null, values)
        db.close()
        return id
    }

    override fun obtenerCondiciones(): List<CondicionMedica> {
        val db = DBHelper(context).readableDatabase
        val cursor = db.query("condicion_medica", null, null, null, null, null, null)
        val condiciones = mutableListOf<CondicionMedica>()
        with(cursor) {
            while (moveToNext()) {
                condiciones.add(
                    CondicionMedica(
                        getInt(getColumnIndexOrThrow("id_condicion")),
                        getInt(getColumnIndexOrThrow("id_mascota")),
                        getString(getColumnIndexOrThrow("nombre"))
                    )
                )
            }
            close()
        }
        return condiciones
    }

    override fun eliminarCondicion(id: Int): Int {
        val db = DBHelper(context).writableDatabase
        val result = db.delete("condicion_medica", "id_condicion = ?", arrayOf(id.toString()))
        db.close()
        return result
    }
}