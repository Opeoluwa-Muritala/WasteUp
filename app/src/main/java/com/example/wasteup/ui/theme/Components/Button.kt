package com.example.wasteup.ui.theme.Components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AppButton(
    text: String = "Log In",
    onClick: () -> Unit,
    color: Color = Color.Green
) {
    Button(
        onClick = {onClick()},
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        ),
        modifier = Modifier.fillMaxWidth().padding(10.dp),
        shape = RoundedCornerShape(10.dp)
    ){
        Text(text, fontWeight = FontWeight.Medium, color = Color.White)
    }
}