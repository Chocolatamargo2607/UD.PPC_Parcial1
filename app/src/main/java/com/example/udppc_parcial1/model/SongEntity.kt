package com.example.udppc_parcial1.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Song")
data class SongEntity(
    @PrimaryKey(autoGenerate = true)
    val songId: Int? = null,
    @ColumnInfo (name = "song_name")val songName: String?,
    @ColumnInfo (name = "song_lyrics")val songLyrics: String?
)

