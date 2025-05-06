package com.example.petcare.data.local

object DBContract {

    const val SQL_CREATE_TIPO_USUARIO = """
        CREATE TABLE tipo_usuario (
            id_tipo_usuario INTEGER PRIMARY KEY AUTOINCREMENT,
            nombre TEXT NOT NULL
        );
    """

    const val SQL_CREATE_USUARIO = """
        CREATE TABLE usuario (
            id_usuario INTEGER PRIMARY KEY AUTOINCREMENT,
            nombre TEXT NOT NULL,
            correo TEXT UNIQUE,
            contrasenia TEXT NOT NULL,
            id_tipo_usuario INTEGER NOT NULL,
            FOREIGN KEY (id_tipo_usuario) REFERENCES tipo_usuario(id_tipo_usuario)
        );
    """

    const val SQL_CREATE_RAZA = """
        CREATE TABLE raza (
            id_raza INTEGER PRIMARY KEY AUTOINCREMENT,
            id_tipo_mascota INTEGER NOT NULL,
            FOREIGN KEY (id_tipo_mascota) REFERENCES tipo_mascota(id_tipo_mascota)
        );
    """
}