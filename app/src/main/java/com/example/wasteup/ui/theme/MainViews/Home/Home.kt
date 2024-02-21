package com.example.wasteup.ui.theme.MainViews.Home

import androidx.annotation.OptIn
import androidx.camera.core.ExperimentalGetImage
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.startup_forge.AppUI.BottomNavigation.BottomMenu
import com.example.wasteup.Navigation.NavRoute
import com.example.wasteup.R
import com.example.wasteup.component24.Component24
import com.example.wasteup.ui.theme.Components.CameraScreen
import com.example.wasteup.ui.theme.Components.Category
import com.example.wasteup.ui.theme.Components.RecycleListItem
import com.google.relay.compose.BoxScopeInstance.columnWeight
import com.google.relay.compose.BoxScopeInstance.rowWeight
import kotlinx.coroutines.delay

@Composable
fun AppScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomMenu(navController = navController)
        }
    ) {
        Column(
            Modifier.padding(it)
        ) {
            NavHost(navController = navController, startDestination = NavRoute.Home.route ){
                composable(NavRoute.Home.route){
                    HomeScreen()
                }
                composable(NavRoute.Explore.route){
                    Box(Modifier.background(Green))
                }
                composable(NavRoute.Profile.route){
                    Box(Modifier.background(Red))
                }
                composable(NavRoute.Feed.route){
                    Box(Modifier.background(Yellow))
                }
            }
        }
    }
}

@OptIn(ExperimentalGetImage::class) @Composable
fun HomeScreen() {
    var loading by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = loading, ) {
        delay(2000)
        loading = false
    }
    Box( ){
    if (loading){
        CameraScreen()
    }
    Column(
        Modifier
            .fillMaxSize()
            .background(White.copy(0.9f))
            .verticalScroll(rememberScrollState())
    ) {

        Box(Modifier.height(IntrinsicSize.Min)){
            Row(
                Modifier
                    .background(Color.Transparent)
                    .fillMaxSize()
                    .padding(bottom = 60.dp)
            ){

            }
        Component24(
            frame2006ImageContent = painterResource(R.drawable.component_24_frame_2006),
            helloDaniel = "Hello, Daniel",
            takeCareOfYourNature = "Take care of your nature!",
            scanner = {loading = true},
            notification = {},
            modifier = Modifier
                .rowWeight(1.0f)
                .columnWeight(1.0f)
        )
    }
        Row {
            Category(
                text = "Categories",
                borderColor = Black,
                textColor = White,
                backgroundColor = Black
            )
            Text(text = "|")
            LazyRow() {
                item {
                    Category(
                        text = "Bottle",
                        borderColor = Green,
                        textColor = Green,
                        backgroundColor = White
                    )
                }
                item {
                    Category(
                        text = "Glass",
                        borderColor = Green,
                        textColor = Green,
                        backgroundColor = White
                    )
                }
                item {
                    Category(
                        text = "Nylon",
                        borderColor = Green,
                        textColor = Green,
                        backgroundColor = White
                    )
                }
                item {
                    Category(
                        text = "Leather",
                        borderColor = Green,
                        textColor = Green,
                        backgroundColor = White
                    )
                }
            }
        }
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Green.copy(0.2f)
            ),
            shape = RoundedCornerShape(20),
            modifier = Modifier.padding(20.dp)
        ) {
            Column(Modifier.padding(10.dp)) {
                Row {
                    Text(text = "♻", color = Green)
                    Text(" Recycling tip of the day", color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    "Rinse plastic containers before recycling them " +
                            "even small food residue can contaminate the entire" +
                            " batch of items.",
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.fillMaxSize().padding(8.dp),
                    lineHeight = TextUnit(15f, TextUnitType.Sp),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = White
                    ),
                ) {
                    Row (Modifier.padding(5.dp), verticalAlignment = Alignment.CenterVertically){
                        Text(text = "Check out learnings", color = Color.Black, fontSize = 9.sp)
                        Icon(imageVector = Icons.Outlined.ArrowForward, contentDescription = "", tint = Black)
                    }
                }

            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text ="Nearby collector Station", fontWeight = FontWeight.Bold, color = Color.Black)
            Text(text = "View all", fontWeight = FontWeight.Thin, color = Color.Black)
        }
        LazyColumn(
            Modifier
                .height(500.dp)
                .padding(10.dp)) {
            item {
                RecycleListItem(image = R.drawable.item_1)
            }
            item {
                RecycleListItem(image = R.drawable.item_1, title = "COHS Recycle Station")
            }
            items(5) {
                RecycleListItem(image = R.drawable.item_1)
            }
            items(5) {
                RecycleListItem(image = R.drawable.item_1, title = "COHS Recycle Station")
            }
        }
        }
    }
}