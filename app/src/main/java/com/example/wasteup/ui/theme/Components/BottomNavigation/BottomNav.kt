package com.example.startup_forge.AppUI.BottomNavigation

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun BottomMenu(navController: NavController){
    var selectedItemIndex by remember {
        mutableIntStateOf(0)
    }


    NavigationBar(
        containerColor = LightGray,
    ) {
        BottomNavItems().forEachIndexed { index, bottomNavItem ->
            var selected = index == selectedItemIndex
            NavigationBarItem(
                selected = selected,
                label = {
                    Text(bottomNavItem.title, fontSize = 9.sp)
                },
                icon = {
                    bottomNavItem.imageId?.let { painterResource(it) }?.let {
                        Icon(
                            painter = it,
                            contentDescription = bottomNavItem.title,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    bottomNavItem.icon?.let {
                        Icon(
                            imageVector = it,
                            contentDescription = bottomNavItem.title,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                },
                onClick = {
                    selectedItemIndex =  index
                    navController.navigate(bottomNavItem.route){
                        launchSingleTop =true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor= Green,
                    selectedTextColor= Green,
                    unselectedIconColor= Color.DarkGray,
                    unselectedTextColor= Black,
                    indicatorColor = LightGray
                )
            )

        }
    }
}




