package com.example.udppc_parcial1.dataManagement

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SongDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSong(songEntity: SongEntity)
    @Query("SELECT * FROM songEntity")
    suspend fun getSongs():List<SongEntity>
}