@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.udppc_parcial1

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.room.Room
import com.example.udppc_parcial1.database.AppDatabase
import com.example.udppc_parcial1.model.SongRepository
import com.example.udppc_parcial1.view.theme.UDPPC_Parcial1Theme
import com.example.udppc_parcial1.view_model.navegation.App_navegation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(this,AppDatabase::class.java, "song_db").build()
        val dao = db.songDao()
        val repository = SongRepository(dao)
        setContent {
            UDPPC_Parcial1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primaryContainer)
                {
                    App_navegation()

                }
            }
        }
    }
}
