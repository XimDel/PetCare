package com.example.petcare.data.local.repositories

import android.content.Context
import com.example.petcare.data.local.Mascota
import com.example.petcare.data.local.MascotaDaoImpl

object MascotaRepository {

    fun obtenerPrimeraMascota(context: Context): Mascota? {
        val dao = MascotaDaoImpl(context)
        return dao.obtenerMascotas().firstOrNull()
    }

    fun guardarMascota(context: Context, mascota: Mascota): Long {
        val dao = MascotaDaoImpl(context)
        return if (mascota.idMascota == 0) {
            dao.insertarMascota(
                mascota.idTipoMascota,
                mascota.idRaza,
                mascota.idPropietario,
                mascota.nombre,
                mascota.edad,
                mascota.pesoKg,
                mascota.codigoQr
            )
        } else {
            dao.actualizarMascota(mascota).toLong()
        }
    }
}