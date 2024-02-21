package com.example.wasteup.Navigation

sealed class NavRoute( val route: String){
    data object Splash: NavRoute("splash_screen")
    data object Login : NavRoute("sign_up_and_login")
    data object Home: NavRoute("home")
    data object SelectCountry: NavRoute("country")
    data object SelectLocation: NavRoute("select_location")
    data object Location: NavRoute("location")
    data object Feed: NavRoute("community")
    data object Explore: NavRoute("educated")
    data object Profile: NavRoute("recycling")
    data object AccountType: NavRoute("account")
    data object MainScreen: NavRoute("main_screen")
}
