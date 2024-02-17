package com.example.wasteup.ui.theme.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AccountType(
    selected: Boolean,
    onClick:() -> Unit,
    text: String
) {

    Column(
         modifier = Modifier
            .clickable(
                onClick = onClick
            )
            .border(
                1.dp,
                if (selected) Color.Green.copy(0.6f) else Color.White.copy(0.5f),
                RoundedCornerShape(10.dp)
            )
             .background(Color.Gray.copy(0.2f),RoundedCornerShape(10.dp))
             .size(150.dp,200.dp)
             .height(IntrinsicSize.Max)
            .width(IntrinsicSize.Max)

        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Box(
            Modifier
                .clip(CircleShape)
                .background(
                    if (selected) Color.Green.copy(0.3f) else Color.LightGray.copy(0.6f)
                ).size(100.dp),

        ) {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "Person",
                tint = if (selected) Color.Green else Color.DarkGray,
                modifier = Modifier.size(80.dp).align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = text,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.height(30.dp))
    }
}