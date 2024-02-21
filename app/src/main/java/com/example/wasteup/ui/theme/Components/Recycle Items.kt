package com.example.wasteup.ui.theme.Components

import android.content.ClipData.Item
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RecycleListItem(
    @DrawableRes image: Int,
    location: String = "150m from your location | 5mins",
    title: String = "Unilorin Recycle Station",
    time: String = "Closes by 6pm"
) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier.padding(10.dp)
    ) {

        Row {
            Column {
                Box(modifier = Modifier){
                    Image(painter = painterResource(id = image), contentDescription = null, modifier = Modifier
                        .size(120.dp)
                        .padding(10.dp))
                }
            }
            Column {
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = location, fontSize = 10.sp, fontWeight = FontWeight.Thin, color = Black)
                
                Text(text = title, fontWeight = FontWeight.Bold, color = Black)
                Text(text = time, fontWeight = FontWeight.Normal, color = Red, fontSize = 8.sp)
                Row(
                    Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Category(
                        text = "Bottle",
                        borderColor = Color.Green,
                        textColor = Color.Green,
                        backgroundColor = Color.White,
                        modifier = Modifier.size(50.dp, 20.dp).padding(2.dp),
                        fontsize = 9
                    )
                    Category(
                        text = "Glass",
                        borderColor = Color.Green,
                        textColor = Color.Green,
                        backgroundColor = Color.White,
                        Modifier.size(50.dp, 20.dp).padding(2.dp),
                        fontsize = 9
                    )
                    Category(
                        text = "Nylon",
                        borderColor = Color.Green,
                        textColor = Color.Green,
                        backgroundColor = Color.White,
                        Modifier.size(50.dp, 20.dp).padding(2.dp),
                        fontsize = 9
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}