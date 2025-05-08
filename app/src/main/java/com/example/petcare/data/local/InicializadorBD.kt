package com.example.petcare.data.local

import android.content.Context

fun inicializarUsuariosPorDefecto(context: Context) {
    val dao = UsuarioDaoImpl(context)
    if (dao.obtenerUsuarios().isEmpty()) {
        dao.insertarUsuario("Usuario1", "usuario1@correo.com", "1234", 1)
        dao.insertarUsuario("Vet1", "vet@correo.com", "abcd", 2)
    }
}