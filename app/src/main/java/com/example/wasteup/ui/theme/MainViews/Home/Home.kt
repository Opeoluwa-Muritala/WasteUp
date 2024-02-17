package com.example.wasteup.ui.theme.MainViews.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.startup_forge.AppUI.BottomNavigation.BottomMenu
import com.example.wasteup.Navigation.NavRoute

@Composable
fun AppScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomMenu(navController = navController)
        }
    ) {
        Column(
            Modifier.padding(it)
        ) {
            NavHost(navController = navController, startDestination = NavRoute.Home.route ){
                composable(NavRoute.Home.route){
                    HomeScreen()
                }
                composable(NavRoute.Location.route){
                    Box(Modifier.background(Green))
                }
                composable(NavRoute.Recycling.route){
                    Box(Modifier.background(Red))
                }
                composable(NavRoute.Community.route){
                    Box(Modifier.background(Yellow))
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {

}