package com.example.udppc_parcial1.model

import com.example.udppc_parcial1.dao.SongDao

class SongRepository (private val songDao: SongDao){
    suspend fun getSongs():List<Song>{
        val entities = songDao.getAll()
        return entities.map{
            Song(songName = it.songName,songLyrics = it.songLyrics)
        }
    }

    suspend fun insertSongs(song: Song){
        val entity = SongEntity(songName = song.songName, songLyrics = song.songLyrics)
        songDao.insert(entity)
    }

}