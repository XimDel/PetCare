package com.example.petcare.data.local

import android.content.ContentValues
import android.content.Context

interface MedicamentoDao {
    fun insertarMedicamento(idMascota: Int, nombre: String, dosis: String?): Long
    fun obtenerMedicamentos(): List<Medicamento>
    fun eliminarMedicamento(id: Int): Int
}

class MedicamentoDaoImpl(private val context: Context) : MedicamentoDao {
    override fun insertarMedicamento(idMascota: Int, nombre: String, dosis: String?): Long {
        val db = DBHelper(context).writableDatabase
        val values = ContentValues().apply {
            put("id_mascota", idMascota)
            put("nombre", nombre)
            put("dosis", dosis)
        }
        val id = db.insert("medicamento", null, values)
        db.close()
        return id
    }

    override fun obtenerMedicamentos(): List<Medicamento> {
        val db = DBHelper(context).readableDatabase
        val cursor = db.query("medicamento", null, null, null, null, null, null)
        val medicamentos = mutableListOf<Medicamento>()
        with(cursor) {
            while (moveToNext()) {
                medicamentos.add(
                    Medicamento(
                        getInt(getColumnIndexOrThrow("id_medicamento")),
                        getInt(getColumnIndexOrThrow("id_mascota")),
                        getString(getColumnIndexOrThrow("nombre")),
                        getString(getColumnIndexOrThrow("dosis"))
                    )
                )
            }
            close()
        }
        return medicamentos
    }

    override fun eliminarMedicamento(id: Int): Int {
        val db = DBHelper(context).writableDatabase
        val result = db.delete("medicamento", "id_medicamento = ?", arrayOf(id.toString()))
        db.close()
        return result
    }
}