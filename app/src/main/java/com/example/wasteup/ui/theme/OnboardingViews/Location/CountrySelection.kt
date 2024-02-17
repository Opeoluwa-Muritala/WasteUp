package com.example.wasteup.ui.theme.OnboardingViews.Location

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wasteup.CountrySelectionBox
import com.example.wasteup.Data.countries
import com.example.wasteup.Navigation.NavRoute
import com.example.wasteup.ui.theme.Components.AppButton

@Composable
fun SelectCountry(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row {

                Box(
                    modifier = Modifier
                        .size(50.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = "Back",
                        Modifier
                            .align(
                                Alignment.Center
                            )
                            .size(30.dp),
                        tint = Color.Black
                    )
                }

                Column {
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Let's get started",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Column {
                Text(text = "Choose Country", fontWeight = FontWeight.Normal, fontSize = 15.sp)
                CountrySelectionBox(label = "country: e.g Nigeria", countries = countries)
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Text(
                    text = "Next, we need to know your location",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp
                )
                Text(
                    text = "To show you Nearby Upcycle stations and how many Upcyclers are in your location",
                    fontWeight = FontWeight.Normal,
                    fontSize = 9.sp
                )
            }

            AppButton(
                text = "Continue",
                onClick = {
                          navController.navigate(NavRoute.SelectLocation.route)
                },
            )
        }

    }
}

@Preview
@Composable
fun COuntySelectionPreview(){
    SelectCountry(rememberNavController())
}