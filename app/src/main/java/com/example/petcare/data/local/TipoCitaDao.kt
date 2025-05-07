package com.example.petcare.data.local

import android.content.ContentValues
import android.content.Context

interface TipoCitaDao {
    fun insertarTipoCita(nombre: String): Long
    fun obtenerTiposCita(): List<TipoCita>
    fun actualizarTipoCita(id: Int, nombre: String): Int
    fun eliminarTipoCita(id: Int): Int
}

class TipoCitaDaoImpl(private val context: Context) : TipoCitaDao {
    override fun insertarTipoCita(nombre: String): Long {
        val db = DBHelper(context).writableDatabase
        val values = ContentValues().apply {
            put("nombre", nombre)
        }
        val id = db.insert("tipo_cita", null, values)
        db.close()
        return id
    }

    override fun obtenerTiposCita(): List<TipoCita> {
        val db = DBHelper(context).readableDatabase
        val cursor = db.query("tipo_cita", null, null, null, null, null, null)
        val tipos = mutableListOf<TipoCita>()
        with(cursor) {
            while (moveToNext()) {
                tipos.add(
                    TipoCita(
                        getInt(getColumnIndexOrThrow("id_tipo_cita")),
                        getString(getColumnIndexOrThrow("nombre"))
                    )
                )
            }
            close()
        }
        return tipos
    }

    override fun actualizarTipoCita(id: Int, nombre: String): Int {
        val db = DBHelper(context).writableDatabase
        val values = ContentValues().apply {
            put("nombre", nombre)
        }
        val result = db.update("tipo_cita", values, "id_tipo_cita = ?", arrayOf(id.toString()))
        db.close()
        return result
    }

    override fun eliminarTipoCita(id: Int): Int {
        val db = DBHelper(context).writableDatabase
        val result = db.delete("tipo_cita", "id_tipo_cita = ?", arrayOf(id.toString()))
        db.close()
        return result
    }
}