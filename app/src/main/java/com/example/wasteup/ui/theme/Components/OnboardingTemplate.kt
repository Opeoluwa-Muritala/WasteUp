package com.example.wasteup.ui.theme.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.*
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.wasteup.R

@Composable
fun OnboardingTemplate(
    title: String = "Welcome to Waste Up",
    description: String = " This is an organisation where we collect waste",
    backgroundImage: String = "",
    button:() -> Unit,
    colored: Int = 1
) {
    Box(
        Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.onboard1),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(1f)
        )
        Box(
            Modifier
                .align(Alignment.BottomStart)
                .height(500.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(text = title, color = Black, fontWeight = FontWeight.Bold)
                Text(text = description, color = Black, fontWeight = FontWeight.Normal)
            }
        }
    }
}


@Preview
@Composable
fun OnboardingPreview(){
    OnboardingPreview()
}