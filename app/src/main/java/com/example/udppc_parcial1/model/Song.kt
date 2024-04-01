package com.example.udppc_parcial1.model

<<<<<<< HEAD
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Song(
    @PrimaryKey val songId:Int,
    @ColumnInfo(name = "songLyrics") val songLyrics:String?
=======
import android.adservices.adid.AdId
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Song(
    @PrimaryKey var songId: Int,
    @ColumnInfo var songLyrics: String
>>>>>>> 0f5a39f65b6051ebe8ca3a65d39a2fc5be7303be
)
