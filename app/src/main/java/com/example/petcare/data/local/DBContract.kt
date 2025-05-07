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

    const val SQL_CREATE_TIPO_MASCOTA = """
        CREATE TABLE tipo_mascota (
            id_tipo_mascota INTEGER PRIMARY KEY AUTOINCREMENT,
            nombre TEXT NOT NULL
        );
    """

    const val SQL_CREATE_TIPO_CITA = """
        CREATE TABLE tipo_cita (
            id_tipo_cita INTEGER PRIMARY KEY AUTOINCREMENT,
            nombre TEXT NOT NULL
        );
    """

    const val SQL_CREATE_MASCOTA = """
        CREATE TABLE mascota (
            id_mascota INTEGER PRIMARY KEY AUTOINCREMENT,
            id_tipo_mascota INTEGER NOT NULL,
            id_raza INTEGER NOT NULL,
            id_propietario INTEGER NOT NULL,
            nombre TEXT NOT NULL,
            edad INTEGER NOT NULL,
            peso_kg INTEGER NOT NULL,
            codigo_qr TEXT NOT NULL,
            FOREIGN KEY (id_tipo_mascota) REFERENCES tipo_mascota(id_tipo_mascota),
            FOREIGN KEY (id_raza) REFERENCES raza(id_raza),
            FOREIGN KEY (id_propietario) REFERENCES usuario(id_usuario)
        );
    """

    const val SQL_CREATE_MEDICAMENTO = """
        CREATE TABLE medicamento (
            id_medicamento INTEGER PRIMARY KEY AUTOINCREMENT,
            id_mascota INTEGER NOT NULL,
            nombre TEXT NOT NULL,
            dosis TEXT,
            FOREIGN KEY (id_mascota) REFERENCES mascota(id_mascota)
        );
    """


    const val SQL_CREATE_VACUNA = """
        CREATE TABLE vacuna (
            id_vacuna INTEGER PRIMARY KEY AUTOINCREMENT,
            id_mascota INTEGER NOT NULL,
            nombre TEXT NOT NULL,
            fecha DATE,
            FOREIGN KEY (id_mascota) REFERENCES mascota(id_mascota)
        );
    """

    const val SQL_CREATE_CONDICION_MEDICA = """
        CREATE TABLE condicion_medica (
            id_condicion INTEGER PRIMARY KEY AUTOINCREMENT,
            id_mascota INTEGER NOT NULL,
            nombre TEXT NOT NULL,
            FOREIGN KEY (id_mascota) REFERENCES mascota(id_mascota)
        );
    """


    const val SQL_CREATE_IMAGEN_MASCOTA = """
        CREATE TABLE imagen_mascota (
            id_imagen INTEGER PRIMARY KEY AUTOINCREMENT,
            id_mascota INTEGER NOT NULL,
            ruta_imagen TEXT NOT NULL,
            FOREIGN KEY (id_mascota) REFERENCES mascota(id_mascota)
        );
    """

    const val SQL_CREATE_TRATAMIENTO = """
        CREATE TABLE tratamiento (
            id_tratamiento INTEGER PRIMARY KEY AUTOINCREMENT,
            id_mascota INTEGER NOT NULL,
            nombre TEXT NOT NULL,
            FOREIGN KEY (id_mascota) REFERENCES mascota(id_mascota)
        );
    """

    const val SQL_CREATE_CITA = """
        CREATE TABLE cita (
            id_cita INTEGER PRIMARY KEY AUTOINCREMENT,
            id_mascota INTEGER NOT NULL,
            id_tipo_cita INTEGER NOT NULL,
            fecha DATE NOT NULL,
            descripcion TEXT,
            FOREIGN KEY (id_mascota) REFERENCES mascota(id_mascota),
            FOREIGN KEY (id_tipo_cita) REFERENCES tipo_cita(id_tipo_cita)
        );
    """

    const val SQL_CREATE_BLOG = """
        CREATE TABLE blog (
            id_blog INTEGER PRIMARY KEY AUTOINCREMENT,
            titulo TEXT NOT NULL,
            contenido TEXT NOT NULL,
            imagen_url TEXT
        );
    """
}