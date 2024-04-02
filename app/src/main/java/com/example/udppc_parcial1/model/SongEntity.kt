package com.example.udppc_parcial1.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.udppc_parcial1.database.Constants

@Entity(tableName = Constants.song_table_name)
data class SongEntity(
    @PrimaryKey(autoGenerate = true)
    val songId: Int? = null,
    @ColumnInfo (name = "song_name")val songName: String?,
    @ColumnInfo (name = "song_lyrics")val songLyrics: String?
)