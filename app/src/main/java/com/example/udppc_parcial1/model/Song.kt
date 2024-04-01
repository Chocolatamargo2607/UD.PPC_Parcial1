package com.example.udppc_parcial1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Song(
    @PrimaryKey val songId:Int,
    @ColumnInfo(name = "songLyrics") val songLyrics:String?
)
