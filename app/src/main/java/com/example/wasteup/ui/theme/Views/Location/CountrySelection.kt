package com.example.wasteup.ui.theme.Views.Location

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wasteup.ui.theme.Components.AppButton

@Composable
fun SelectCountry() {
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
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row {

                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.LightGray)
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
                Spacer(modifier = Modifier.width(50.dp))
                Text(
                    text = "Let's get started",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }
            Column {
                Text(text = "Choose Country", fontWeight = FontWeight.Normal, fontSize = 15.sp)
                TextField(value = "Search", onValueChange = {})
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Text(
                    text = "Next, we need to know your location",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
                Text(
                    text = "To show you Nearby Upcycle stations and how many Upcyclers are in your location",
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp
                )
            }
            AppButton(text = "Continue") {

            }
        }

    }
}

@Preview
@Composable
fun COuntySelectionPreview(){
    SelectCountry()
}