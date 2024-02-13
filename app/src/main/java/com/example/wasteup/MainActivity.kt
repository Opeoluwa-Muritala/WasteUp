package com.example.wasteup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wasteup.Navigation.NavRoute
import com.example.wasteup.ui.theme.Views.Location.SelectCountry
import com.example.wasteup.ui.theme.Views.SignUp.SignUp_and_SignIn_Screen
import com.example.wasteup.ui.theme.Views.SplashScreen.SplashScreen
import com.example.wasteup.ui.theme.WasteUpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            
            WasteUpTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = NavRoute.Splash.route){

                        composable(NavRoute.Splash.route){
                            SplashScreen(navController = navController)
                        }

                        composable(NavRoute.Login.route){
                            SignUp_and_SignIn_Screen(navController)
                        }

                        composable(NavRoute.Home.route){
                        }
                        composable(NavRoute.SelectCountry.route){
                            SelectCountry()
                        }
                        composable(NavRoute.Location.route){

                        }
                    }
                }
            }
        }
    }
}

