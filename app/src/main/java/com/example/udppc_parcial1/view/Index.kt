package com.example.udppc_parcial1.view.ui.theme

import android.content.Context
import android.widget.Toast
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.udppc_parcial1.view.theme.UDPPC_Parcial1Theme
import com.example.udppc_parcial1.view_model.navegation.App_screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Index(navController: NavController){
    val context = LocalContext.current
    SearchBar(
        query = "Search",
        onQueryChange ={} ,
        onSearch = {
            Toast.makeText(context, "Search", Toast.LENGTH_SHORT).show()
        },
        active = true ,
        onActiveChange =
        {

        }   ) {

    }
}

@Preview(showBackground = true)
@Composable
fun Index_preview() {
    Index(NavController(LocalContext.current))
}