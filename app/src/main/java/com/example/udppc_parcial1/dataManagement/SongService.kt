package com.example.udppc_parcial1.dataManagement

import android.annotation.SuppressLint
import android.content.ContentValues
import android.util.Range

class SongService(private val dbHelper:Helper) {

    @SuppressLint("Range")
     fun getAllCanciones(): List<SongDTO> {
        val db = dbHelper.readableDatabase
        val cursor = db.query("Song", null, null, null, null, null, null)
        val songs = mutableListOf<SongDTO>()

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex("id"))
                val nombre = cursor.getString(cursor.getColumnIndex("nombre"))
                val fecha = cursor.getString(cursor.getColumnIndex("fecha"))
                val letra = cursor.getString(cursor.getColumnIndex("letra"))
                val cancion = SongDTO(id, nombre, fecha, letra)
                songs.add(cancion)
            } while (cursor.moveToNext())
        }

        cursor.close()
        return songs
    }
     fun save(song: SongDTO): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("nombre", song.nombre)
            put("fecha", song.fecha)
            put("letra", song.letra)
        }
        return db.insert("Song", null, values)
    }
    fun delete(id: Int) {
        val db = dbHelper.writableDatabase
        db.delete("Song", "id=?", arrayOf(id.toString()))
    }
    fun findByNombre(nombre: String): SongDTO? {
        val db = dbHelper.readableDatabase
        val projection = arrayOf("id", "nombre", "fecha", "letra")
        val selection = "nombre = ?"
        val selectionArgs = arrayOf(nombre)
        val sortOrder = "nombre DESC"

        val cursor = db.query(
            "Song",
            projection,
            selection,
            selectionArgs,
            null,
            null,
            sortOrder
        )
        with(cursor) {
            while (moveToNext()) {
                val itemId = getLong(getColumnIndexOrThrow("id"))
                val nombre = getString(getColumnIndexOrThrow("nombre"))
                val fecha = getString(getColumnIndexOrThrow("fecha"))
                val letra = getString(getColumnIndexOrThrow("letra"))
                return SongDTO(itemId.toInt(), nombre, fecha, letra)
            }
        }
        return null
    }


}