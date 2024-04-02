package com.example.udppc_parcial1.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.udppc_parcial1.dao.SongDao
import com.example.udppc_parcial1.model.SongEntity

@Database(entities = [SongEntity::class],version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun songDao(): SongDao

}