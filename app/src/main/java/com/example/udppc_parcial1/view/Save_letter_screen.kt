package com.example.udppc_parcial1.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun Save_letter_screen(navController: NavController){

}

@Composable
fun MessageCard(name:String){
    Text(text = "Guardar letra")
    Button(onClick = { /*TODO*/ }) {
        Text(text = "Guardar Cancion")
        
    }
    Column {

    }
}

@Preview
@Composable
fun PreviewMessageCard(){
    MessageCard("Android")
}