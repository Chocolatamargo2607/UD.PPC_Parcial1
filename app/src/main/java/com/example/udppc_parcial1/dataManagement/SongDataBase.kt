package com.example.udppc_parcial1.dataManagement

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [SongEntity::class],version = 1)
abstract class SongDataBase : RoomDatabase() {
    abstract val dao: SongDao
}