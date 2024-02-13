package com.example.wasteup.Navigation

sealed class NavRoute( val route: String){
    data object Splash: NavRoute("splash_screen")
    data object Login : NavRoute("sign_up_and_login")
    data object Home: NavRoute("home")
    data object SelectCountry: NavRoute("country")
    data object Location: NavRoute("location")
}
