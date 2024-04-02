package com.example.udppc_parcial1.view

import android.widget.Toast
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
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.udppc_parcial1.view_model.navegation.App_screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//Genera la pantalla de practica con maraca
fun Practice_maraca_screen(navController: NavController){

    val context = LocalContext.current.applicationContext
    Row(){
        TopAppBar(
            title = {Text(text=" Maraca Instructions")},
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor =MaterialTheme.colorScheme.primary ,
                titleContentColor = Color.White
            ),
            navigationIcon = {
                IconButton(onClick = { navController.navigate(route = App_screens.Index.router)}) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        //Texto explicativo
        Text(text = "Instructivo: \n" +
                "- En la parte inferior verás un botón llamado /Start Practice/. Presiona este botón para activar la función de las maracas.\n" +
                "- Una vez activadas las maracas, sostén tu dispositivo móvil con firmeza y agítalo de manera rápida.\n" +
                "- La aplicación detectará la sacudida y reproducirá el sonido característico de las maracas.\n" +
                "- Si deseas desactivar la función de las maracas, simplemente vuelve a la pantalla principal. \n" +
                "¡Ahora estás listo para disfrutar de la experiencia de tener unas maracas virtuales en tu dispositivo móvil! Diviértete agitando tu teléfono y creando ritmos únicos.",color = Color.Black
        )
        Spacer(modifier = Modifier.height(36.dp))

        Button(onClick = {navController.navigate(route = App_screens.Maraca_screen.router)}) {
            Text(text = "Start practice ‼\uFE0F")
        }

    }

}
@Preview(showBackground = true)
@Composable
fun Practice_maraca_screen_preview() {
    Practice_maraca_screen(NavController(LocalContext.current))
}
