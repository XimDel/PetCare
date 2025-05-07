package com.example.petcare.data.local

import android.content.ContentValues
import android.content.Context

class UsuarioDaoImpl(private val context: Context) : UsuarioDao {

    override fun insertarUsuario(nombre: String, correo: String, contrasena: String, idTipoUsuario: Int): Long {
        val db = DBHelper(context).writableDatabase
        val values = ContentValues().apply {
            put("nombre", nombre)
            put("correo", correo)
            put("contrasenia", contrasena)
            put("id_tipo_usuario", idTipoUsuario)
        }
        val id = db.insert("usuario", null, values)
        db.close()
        return id
    }

    override fun obtenerUsuarios(): List<Usuario> {
        val db = DBHelper(context).readableDatabase
        val cursor = db.query("usuario", null, null, null, null, null, null)
        val usuarios = mutableListOf<Usuario>()
        with(cursor) {
            while (moveToNext()) {
                usuarios.add(
                    Usuario(
                        getInt(getColumnIndexOrThrow("id_usuario")),
                        getString(getColumnIndexOrThrow("nombre")),
                        getString(getColumnIndexOrThrow("correo")),
                        getString(getColumnIndexOrThrow("contrasenia")),
                        getInt(getColumnIndexOrThrow("id_tipo_usuario"))
                    )
                )
            }
            close()
        }
        return usuarios
    }

    override fun actualizarUsuario(idUsuario: Int, nombre: String, correo: String, contrasena: String): Int {
        val db = DBHelper(context).writableDatabase
        val values = ContentValues().apply {
            put("nombre", nombre)
            put("correo", correo)
            put("contrasenia", contrasena)
        }
        val result = db.update("usuario", values, "id_usuario = ?", arrayOf(idUsuario.toString()))
        db.close()
        return result
    }

    override fun eliminarUsuario(idUsuario: Int): Int {
        val db = DBHelper(context).writableDatabase
        val result = db.delete("usuario", "id_usuario = ?", arrayOf(idUsuario.toString()))
        db.close()
        return result
    }
}

interface UsuarioDao {
    fun insertarUsuario(
        nombre: String,
        correo: String,
        contrasena: String,
        idTipoUsuario: Int
    ): Long

    fun obtenerUsuarios(): List<Usuario>

    fun actualizarUsuario(
        idUsuario: Int,
        nombre: String,
        correo: String,
        contrasena: String
    ): Int

    fun eliminarUsuario(idUsuario: Int): Int
}
