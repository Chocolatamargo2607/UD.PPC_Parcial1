package com.example.udppc_parcial1.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Song(
    @PrimaryKey var songId: Int,
    @ColumnInfo var songLyrics: String
)