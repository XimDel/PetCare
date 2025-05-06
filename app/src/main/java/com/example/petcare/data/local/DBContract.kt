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
        nombre TEXT NOT NULL,
        dosis TEXT,
        observaciones TEXT
    );
    """

    const val SQL_CREATE_VACUNA = """
    CREATE TABLE vacuna (
        id_vacuna INTEGER PRIMARY KEY AUTOINCREMENT,
        nombre TEXT NOT NULL,
        fecha_aplicacion DATE,
        observaciones TEXT
    );
    """

    const val SQL_CREATE_CONDICION_MEDICA = """
    CREATE TABLE condicion_medica (
        id_condicion_medica INTEGER PRIMARY KEY AUTOINCREMENT,
        nombre TEXT NOT NULL,
        descripcion TEXT
    );
    """
}