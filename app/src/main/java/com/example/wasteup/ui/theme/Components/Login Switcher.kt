package com.example.wasteup.ui.theme.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SwitchingButton(
    switch: Boolean,
    clickOne: () -> Unit,
    clickTwo: () -> Unit

) {
    Row(
        Modifier
            .height(40.dp)
            .width(180.dp)
            .border(1.dp, Color.LightGray, RoundedCornerShape(10.dp))
    ){
        Box(
            Modifier
                .size(90.dp, 40.dp)
                .padding(4.dp)
                .background(
                    if (switch) Color.Green else Color.White,
                    RoundedCornerShape(10.dp)
                )
        ){
            Text(
                "Log In",
                modifier = Modifier
                    .align(Alignment.Center)
                    .clickable { clickOne() },
                color = if (switch) Color.White else Color.Black,
                fontSize = 10.sp
            )
        }

        Box(
            Modifier
                .size(90.dp, 40.dp)
                .padding(4.dp)
                .background(
                    if (!switch) Color.Green else Color.White,
                    RoundedCornerShape(10.dp)
                )
        ){
            Text(
                "Sign Up",
                modifier = Modifier
                    .align(Alignment.Center)
                    .clickable { clickTwo() },
                color =  if (!switch) Color.White else Color.Black,
                fontSize = 10.sp

            )
        }
    }
}