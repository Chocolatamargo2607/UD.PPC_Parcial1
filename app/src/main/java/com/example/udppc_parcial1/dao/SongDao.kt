package com.example.udppc_parcial1.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.udppc_parcial1.database.Constants
import com.example.udppc_parcial1.model.SongEntity

@Dao
interface SongDao {
    @Query("SELECT * FROM ${Constants.song_table_name}")
    fun getAll():List<SongEntity>
    @Query("SELECT * FROM ${Constants.song_table_name} WHERE songId IN (:SongIds)")
    fun loadAllByIds(SongIds:IntArray):List<SongEntity>
    @Insert
    fun insert(vararg Songs: SongEntity)
    @Delete
    fun delete(song: SongEntity)
    @Update
    fun update(song: SongEntity)
}