package com.example.udppc_parcial1.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.udppc_parcial1.database.AppDatabase
import com.example.udppc_parcial1.model.SongEntity
import com.example.udppc_parcial1.view_model.navegation.App_screens
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Save_letter_screen(navController: NavController, db:AppDatabase){

    var name_song by remember {
        mutableStateOf("")
    }
    var letter by remember {
        mutableStateOf("")
    }
    Row(
        modifier = androidx.compose.ui.Modifier.padding(16.dp)
    ) {

        Button(onClick = { navController.navigate(route = App_screens.Index.router)}) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null
            )
            Text(text = "  Back")
        }
    }

    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        TextField(
            value = name_song,
            onValueChange = {
                name_song = it
            },
            label = {
                Text(text = "Name Song")
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.primary

            )


        )
        Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
        Text(text = "Lyric of the Song")
        Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
        TextField(
            value = letter,
            onValueChange = {
                letter = it
            },
            placeholder = {
                Text(text = "Write the lyrics")
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.primary

            )
        )
        Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
        Button(onClick = { db.songDao().insert(SongEntity( songName = name_song , songLyrics = letter)) }) {
            Text(text = "Save lyric")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun Save_letter_screen_preview() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val db = AppDatabase.getInstance(context)
    Save_letter_screen(navController = navController, db = db)
}
