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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun Save_letter_screen(navController: NavController){
    var name_song by remember {
        mutableStateOf("")
    }
    var letter by remember {
        mutableStateOf("")
    }
    Row(
        modifier = androidx.compose.ui.Modifier.padding(16.dp)
    ) {

        Button(onClick = { /*TODO*/ }) {
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
            }


        )
        Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
        Text(text = "Lyric of the Song",color = Color.LightGray)
        Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
        TextField(
            value = letter,
            onValueChange = {
                letter = it
            },
            placeholder = {
                Text(text = "Write the lyrics")
            }
        )
        Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Save lyric")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun Save_letter_screen_preview() {
    Save_letter_screen(NavController(LocalContext.current))
}