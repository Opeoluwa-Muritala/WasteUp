package com.example.wasteup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wasteup.Navigation.NavRoute
import com.example.wasteup.ui.theme.MainViews.Home.AppScreen
import com.example.wasteup.ui.theme.OnboardingViews.AccountType.SelectAccountType
import com.example.wasteup.ui.theme.OnboardingViews.Location.LocationScreen
import com.example.wasteup.ui.theme.OnboardingViews.Location.SelectCountry
import com.example.wasteup.ui.theme.OnboardingViews.SignUp.SignUp_and_SignIn_Screen
import com.example.wasteup.ui.theme.OnboardingViews.SplashScreen.SplashScreen
import com.example.wasteup.ui.theme.WasteUpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            
            WasteUpTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = NavRoute.Splash.route){

                        composable(NavRoute.Splash.route){
                            SplashScreen(navController = navController)
                        }

                        composable(NavRoute.Login.route){
                            SignUp_and_SignIn_Screen(navController)
                        }

                        composable(NavRoute.MainScreen.route){
                            AppScreen()
                        }
                        composable(NavRoute.SelectCountry.route){
                            SelectCountry(navController)
                        }
                        composable(NavRoute.SelectLocation.route){
                            LocationScreen(navController)
                        }
                        composable(NavRoute.AccountType.route){
                            SelectAccountType(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

