package com.definelab.cofeeappusingcompose.ui_components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.definelab.cofeeappusingcompose.R
import com.definelab.cofeeappusingcompose.presentation.navigation.Routes
import com.definelab.cofeeappusingcompose.presentation.ui.theme.Lightbrown

//@Preview(showBackground = true)
@Composable
fun BottomNavbar(
    navController: NavController,routes:String
){
    //Bottom Nav Item

    val navItems = listOf(
        NavItems("Home",R.drawable.home_icon, Routes.HomeScreen),
        NavItems("Cart",R.drawable.cart_icon, Routes.CartScreen),
        NavItems("Favourites",R.drawable.favorite_icon, Routes.FavouriteScreen),
        NavItems("Profile",R.drawable.profile, Routes.ProfileScreen)
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.height(100.dp)) {

        navItems.forEach {
            navItems ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(navItems.icon),
                        contentDescription = navItems.title
                    )
                },
                label = { Text(text = navItems.title) },
                modifier = Modifier.size(50.dp),

                //Handling BottomBAr Navigation
                onClick = {
                    navController.navigate(navItems.routes){
                        launchSingleTop = true
                    }

                },
                alwaysShowLabel = true,
               selected = navItems.title == routes,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Lightbrown,
                    selectedTextColor = Lightbrown,
                    unselectedIconColor = Color.DarkGray,
                    unselectedTextColor = Color.DarkGray,
                    indicatorColor = Lightbrown.copy(alpha = 0.1f)
                )

            )
        }

    }
}

data class NavItems(
    val title:String,
    val icon: Int,
    val routes: Routes
)