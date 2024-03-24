package com.example.udppc_parcial1.view_model.navegation

sealed class App_screens (val router:String){
    object Index:App_screens("index")
    object Save_letter_screen:App_screens("save_letter_screen")
    object Practice_maraca_screen:App_screens("practice_maraca_screen")
    object Practice_tambor_screen:App_screens("practice_tambor_screen")
    object Read_letter_screen:App_screens("read_letter_screen")
}