package com.example.wasteup.ui.theme.Components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Category(
    text: String,
    borderColor: Color?,
    textColor: Color?,
    backgroundColor: Color?,
    modifier: Modifier = Modifier,
    fontsize : Int = 10,
    width : Int = 80,
    height : Int = 50
) {
    backgroundColor?.let {
        CardDefaults.cardColors(
            containerColor = it,
        )
    }?.let {
        borderColor?.let { it1 -> modifier.border(2.dp, it1, RoundedCornerShape(50)) }?.let { it2 ->
            Card(
            shape = RoundedCornerShape(50),
            colors = it,
                modifier = it2.size(width.dp, height.dp)
        ) {
                Column(
                    Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    textColor?.let { it1 -> Text(text, color = it1, fontSize = fontsize.sp) }
                }

            }
        }
    }
}