package com.example.petcare.data.local

import android.content.ContentValues
import android.content.Context

interface ImagenMascotaDao {
    fun insertarImagen(idMascota: Int, ruta: String): Long
    fun obtenerImagenes(): List<ImagenMascota>
    fun eliminarImagen(id: Int): Int
}

class ImagenMascotaDaoImpl(private val context: Context) : ImagenMascotaDao {
    override fun insertarImagen(idMascota: Int, ruta: String): Long {
        val db = DBHelper(context).writableDatabase
        val values = ContentValues().apply {
            put("id_mascota", idMascota)
            put("ruta_imagen", ruta)
        }
        val id = db.insert("imagen_mascota", null, values)
        db.close()
        return id
    }

    override fun obtenerImagenes(): List<ImagenMascota> {
        val db = DBHelper(context).readableDatabase
        val cursor = db.query("imagen_mascota", null, null, null, null, null, null)
        val imagenes = mutableListOf<ImagenMascota>()
        with(cursor) {
            while (moveToNext()) {
                imagenes.add(
                    ImagenMascota(
                        getInt(getColumnIndexOrThrow("id_imagen")),
                        getInt(getColumnIndexOrThrow("id_mascota")),
                        getString(getColumnIndexOrThrow("ruta_imagen"))
                    )
                )
            }
            close()
        }
        return imagenes
    }

    override fun eliminarImagen(id: Int): Int {
        val db = DBHelper(context).writableDatabase
        val result = db.delete("imagen_mascota", "id_imagen = ?", arrayOf(id.toString()))
        db.close()
        return result
    }
}