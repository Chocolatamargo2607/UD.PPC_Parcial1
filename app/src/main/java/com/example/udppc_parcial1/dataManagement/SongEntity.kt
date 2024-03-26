package com.example.udppc_parcial1.dataManagement

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SongEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo var songName:String,
    @ColumnInfo var songLyrics:String
)
