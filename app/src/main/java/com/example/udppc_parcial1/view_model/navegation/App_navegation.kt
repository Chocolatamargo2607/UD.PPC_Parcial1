package com.example.udppc_parcial1.view_model.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.udppc_parcial1.view.Maraca_screen
import com.example.udppc_parcial1.view.Practice_maraca_screen
import com.example.udppc_parcial1.view.Practice_tambor_screen
import com.example.udppc_parcial1.view.Read_letter_screen
import com.example.udppc_parcial1.view.Save_letter_screen
import com.example.udppc_parcial1.view.Tambor_screen
import com.example.udppc_parcial1.view.ui.theme.Index


@Composable
fun App_navegation(){
    val navController = rememberNavController()
    NavHost(navController = navController,startDestination = App_screens.Index.router){
        composable(route = App_screens.Index.router){ Index(navController) }
      //  composable(route = App_screens.Save_letter_screen.router){Save_letter_screen(navController)}
        composable(route = App_screens.Practice_maraca_screen.router){Practice_maraca_screen(navController)}
        composable(route = App_screens.Practice_tambor_screen.router){Practice_tambor_screen(navController)}
        composable(route = App_screens.Read_letter_screen.router){Read_letter_screen(navController)}
        composable(route = App_screens.Maraca_screen.router){ Maraca_screen(navController)}
        composable(route = App_screens.Tambor_screen.router){ Tambor_screen(navController)}
    }
}