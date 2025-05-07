package com.example.petcare.data.local

import android.content.ContentValues
import android.content.Context

class TipoUsuarioDaoImpl(private val context: Context) : TipoUsuarioDao {

    override fun insertarTipoUsuario(nombre: String): Long {
        val db = DBHelper(context).writableDatabase
        val values = ContentValues().apply {
            put("nombre", nombre)
        }
        val id = db.insert("tipo_usuario", null, values)
        db.close()
        return id
    }

    override fun obtenerTiposUsuario(): List<TipoUsuario> {
        val db = DBHelper(context).readableDatabase
        val cursor = db.query("tipo_usuario", null, null, null, null, null, null)
        val tipos = mutableListOf<TipoUsuario>()
        with(cursor) {
            while (moveToNext()) {
                tipos.add(
                    TipoUsuario(
                        getInt(getColumnIndexOrThrow("id_tipo_usuario")),
                        getString(getColumnIndexOrThrow("nombre"))
                    )
                )
            }
            close()
        }
        return tipos
    }

    override fun actualizarTipoUsuario(id: Int, nombre: String): Int {
        val db = DBHelper(context).writableDatabase
        val values = ContentValues().apply {
            put("nombre", nombre)
        }
        val result = db.update("tipo_usuario", values, "id_tipo_usuario = ?", arrayOf(id.toString()))
        db.close()
        return result
    }

    override fun eliminarTipoUsuario(id: Int): Int {
        val db = DBHelper(context).writableDatabase
        val result = db.delete("tipo_usuario", "id_tipo_usuario = ?", arrayOf(id.toString()))
        db.close()
        return result
    }
}

interface TipoUsuarioDao {
    fun insertarTipoUsuario(nombre: String): Long
    fun obtenerTiposUsuario(): List<TipoUsuario>
    fun actualizarTipoUsuario(id: Int, nombre: String): Int
    fun eliminarTipoUsuario(id: Int): Int
}
