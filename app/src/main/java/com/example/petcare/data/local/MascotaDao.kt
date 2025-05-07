package com.example.petcare.data.local

import android.content.ContentValues
import android.content.Context

interface MascotaDao {
    fun insertarMascota(
        idTipoMascota: Int,
        idRaza: Int,
        idPropietario: Int,
        nombre: String,
        edad: Int,
        pesoKg: Int,
        codigoQr: String
    ): Long

    fun obtenerMascotas(): List<Mascota>
    fun actualizarMascota(mascota: Mascota): Int
    fun eliminarMascota(id: Int): Int
}

class MascotaDaoImpl(private val context: Context) : MascotaDao {
    override fun insertarMascota(idTipoMascota: Int, idRaza: Int, idPropietario: Int, nombre: String, edad: Int, pesoKg: Int, codigoQr: String): Long {
        val db = DBHelper(context).writableDatabase
        val values = ContentValues().apply {
            put("id_tipo_mascota", idTipoMascota)
            put("id_raza", idRaza)
            put("id_propietario", idPropietario)
            put("nombre", nombre)
            put("edad", edad)
            put("peso_kg", pesoKg)
            put("codigo_qr", codigoQr)
        }
        val id = db.insert("mascota", null, values)
        db.close()
        return id
    }

    override fun obtenerMascotas(): List<Mascota> {
        val db = DBHelper(context).readableDatabase
        val cursor = db.query("mascota", null, null, null, null, null, null)
        val mascotas = mutableListOf<Mascota>()
        with(cursor) {
            while (moveToNext()) {
                mascotas.add(
                    Mascota(
                        getInt(getColumnIndexOrThrow("id_mascota")),
                        getInt(getColumnIndexOrThrow("id_tipo_mascota")),
                        getInt(getColumnIndexOrThrow("id_raza")),
                        getInt(getColumnIndexOrThrow("id_propietario")),
                        getString(getColumnIndexOrThrow("nombre")),
                        getInt(getColumnIndexOrThrow("edad")),
                        getInt(getColumnIndexOrThrow("peso_kg")),
                        getString(getColumnIndexOrThrow("codigo_qr"))
                    )
                )
            }
            close()
        }
        return mascotas
    }

    override fun actualizarMascota(mascota: Mascota): Int {
        val db = DBHelper(context).writableDatabase
        val values = ContentValues().apply {
            put("id_tipo_mascota", mascota.idTipoMascota)
            put("id_raza", mascota.idRaza)
            put("id_propietario", mascota.idPropietario)
            put("nombre", mascota.nombre)
            put("edad", mascota.edad)
            put("peso_kg", mascota.pesoKg)
            put("codigo_qr", mascota.codigoQr)
        }
        val result = db.update("mascota", values, "id_mascota = ?", arrayOf(mascota.idMascota.toString()))
        db.close()
        return result
    }

    override fun eliminarMascota(id: Int): Int {
        val db = DBHelper(context).writableDatabase
        val result = db.delete("mascota", "id_mascota = ?", arrayOf(id.toString()))
        db.close()
        return result
    }
}