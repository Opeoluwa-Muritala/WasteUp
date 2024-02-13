package com.example.wasteup.ui.theme.Components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun Logo(
    color: Color = Color.White,
    fontSize: Int = 40,
    fontWeight: FontWeight = FontWeight.Thin
) {
    Text(
        text = "WASTE UP",
        fontSize = fontSize.sp,
        textAlign = TextAlign.Center,
        color = color,
        fontWeight = fontWeight,
        fontFamily = FontFamily.SansSerif.also { FontFamily.Cursive }
    )
}