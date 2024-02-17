package com.example.wasteup.ui.theme.OnboardingViews.AccountType

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.*
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wasteup.Navigation.NavRoute
import com.example.wasteup.ui.theme.Components.AccountType
import com.example.wasteup.ui.theme.Components.AppButton
import com.example.wasteup.ui.theme.OnboardingViews.Location.SelectCountry

@Composable
fun SelectAccountType(
    navController: NavController
) {
    var selected by remember {
        mutableStateOf(false)
    }
    var selected2 by remember {
        mutableStateOf(false)
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(White)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Set account type",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Black
        )
        Text(
            text = "Please select one account type",
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp,
            color = Black
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 10.dp, end = 10.dp)
        ) {
            AccountType(selected = selected, onClick = { selected = !selected;
                if (selected2)selected2 = !selected2 }, text = "Business")
            Spacer(modifier = Modifier.width(10.dp))
            AccountType(selected = selected2, onClick = { selected2 = !selected2;
                if (selected) selected = !selected}, text = "Customer")
        }
        AppButton(
            "Continue",

            color = if (selected || selected2) Green else  Color.LightGray.copy(0.6f),
            onClick = {
                navController.navigate(NavRoute.SelectCountry.route)
            }
        )
    }
}