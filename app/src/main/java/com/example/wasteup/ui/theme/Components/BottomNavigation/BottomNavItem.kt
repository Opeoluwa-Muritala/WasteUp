package com.example.startup_forge.AppUI.BottomNavigation

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AddCircle
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
            BottomNavItem("Explore", Icons.Outlined.AddCircle  , route = NavRoute.Explore.route),
            BottomNavItem("Feed", icon = Icons.Outlined.LocationOn, route = NavRoute.Feed.route),
            BottomNavItem("Profile", icon = Icons.Outlined.AccountCircle, route = NavRoute.Profile.route)
        )
    }

