package com.example.udppc_parcial1.view

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.udppc_parcial1.R
import com.example.udppc_parcial1.view_model.navegation.App_screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Tambor_screen(navController: NavController){
    val context = LocalContext.current
    val oneTapMediaPlayer = MediaPlayer.create(context, R.raw.drum_one_sound)

    val doubleTapMediaPlayer = remember {
        MediaPlayer.create(context, R.raw.drum_two_sound)
    }
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.tambor),
            contentScale = ContentScale.FillBounds ,
            modifier = Modifier
                .align(Alignment.Center)
                .size(260.dp)

                .pointerInput(Unit) {
                    detectTapGestures(
                        onDoubleTap = {
                            doubleTapMediaPlayer.start()
                        }
                        , onTap = {
                            oneTapMediaPlayer.start()
                        }

                    )
                },
            contentDescription = "Fondo"
        )
    }
    Row(){
        TopAppBar(
            title = { Text(text=" Drum Instructions") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary ,
                titleContentColor = Color.White
            ),
            navigationIcon = {
                IconButton(onClick = { navController.navigate(route = App_screens.Practice_tambor_screen.router)}) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun Tambor_screen_preview() {
    Tambor_screen(NavController(LocalContext.current))
}