package com.example.udppc_parcial1.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.udppc_parcial1.MainActivity
import com.example.udppc_parcial1.dao.SongDao
import com.example.udppc_parcial1.model.Song
import com.example.udppc_parcial1.model.SongEntity
import com.example.udppc_parcial1.model.SongRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow
class songViewModel(private val repository: SongRepository) : ViewModel() {
    var state by mutableStateOf(null)
        private set
    fun addSong(songEntity: SongEntity){
        viewModelScope.launch {

        }
    }
}