package com.example.petcare.data.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.petcare.data.local.DBContract.SQL_CREATE_CONDICION_MEDICA
import com.example.petcare.data.local.DBContract.SQL_CREATE_MASCOTA
import com.example.petcare.data.local.DBContract.SQL_CREATE_MEDICAMENTO
import com.example.petcare.data.local.DBContract.SQL_CREATE_RAZA
import com.example.petcare.data.local.DBContract.SQL_CREATE_TIPO_CITA
import com.example.petcare.data.local.DBContract.SQL_CREATE_TIPO_MASCOTA
import com.example.petcare.data.local.DBContract.SQL_CREATE_TIPO_USUARIO
import com.example.petcare.data.local.DBContract.SQL_CREATE_USUARIO
import com.example.petcare.data.local.DBContract.SQL_CREATE_VACUNA

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_TIPO_USUARIO)
        db.execSQL(SQL_CREATE_USUARIO)
        db.execSQL(SQL_CREATE_TIPO_MASCOTA)
        db.execSQL(SQL_CREATE_RAZA)
        db.execSQL(SQL_CREATE_MASCOTA)
//        db.execSQL(SQL_CREATE_IMAGEN_MASCOTA)
        db.execSQL(SQL_CREATE_TIPO_CITA)
//        db.execSQL(SQL_CREATE_CITA)
        db.execSQL(SQL_CREATE_VACUNA)
        db.execSQL(SQL_CREATE_MEDICAMENTO)
//        db.execSQL(SQL_CREATE_TRATAMIENTO)
        db.execSQL(SQL_CREATE_CONDICION_MEDICA)
//        db.execSQL(SQL_CREATE_BLOG)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }

    companion object {
        const val DATABASE_NAME = "veterinaria.db"
        const val DATABASE_VERSION = 1
    }
}