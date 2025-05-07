package com.example.petcare.data.local

import android.content.ContentValues
import android.content.Context

interface BlogDao {
    fun insertarBlog(titulo: String, contenido: String, imagenUrl: String?): Long
    fun obtenerBlogs(): List<Blog>
    fun eliminarBlog(id: Int): Int
}

class BlogDaoImpl(private val context: Context) : BlogDao {
    override fun insertarBlog(titulo: String, contenido: String, imagenUrl: String?): Long {
        val db = DBHelper(context).writableDatabase
        val values = ContentValues().apply {
            put("titulo", titulo)
            put("contenido", contenido)
            put("imagen_url", imagenUrl)
        }
        val id = db.insert("blog", null, values)
        db.close()
        return id
    }

    override fun obtenerBlogs(): List<Blog> {
        val db = DBHelper(context).readableDatabase
        val cursor = db.query("blog", null, null, null, null, null, null)
        val blogs = mutableListOf<Blog>()
        with(cursor) {
            while (moveToNext()) {
                blogs.add(
                    Blog(
                        getInt(getColumnIndexOrThrow("id_blog")),
                        getString(getColumnIndexOrThrow("titulo")),
                        getString(getColumnIndexOrThrow("contenido")),
                        getString(getColumnIndexOrThrow("imagen_url"))
                    )
                )
            }
            close()
        }
        return blogs
    }

    override fun eliminarBlog(id: Int): Int {
        val db = DBHelper(context).writableDatabase
        val result = db.delete("blog", "id_blog = ?", arrayOf(id.toString()))
        db.close()
        return result
    }
}