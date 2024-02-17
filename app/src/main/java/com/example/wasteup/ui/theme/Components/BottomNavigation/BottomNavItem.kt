package com.example.startup_forge.AppUI.BottomNavigation

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.wasteup.Navigation.NavRoute
import com.example.wasteup.R

data class BottomNavItem(
    val title: String,
    val icon:ImageVector? = null,
    @DrawableRes val imageId:Int? = null,
    val route: String
)
    fun BottomNavItems(): List<BottomNavItem>{
        return listOf(
            BottomNavItem("Home", Icons.Outlined.Home , route = NavRoute.Home.route),
            BottomNavItem("Community", imageId = R.drawable.community  , route = NavRoute.Community.route),
            BottomNavItem("Location", icon = Icons.Outlined.LocationOn, route = NavRoute.Location.route),
            BottomNavItem("Business", icon = Icons.Outlined.ShoppingCart, route = NavRoute.Recycling.route)
        )
    }

