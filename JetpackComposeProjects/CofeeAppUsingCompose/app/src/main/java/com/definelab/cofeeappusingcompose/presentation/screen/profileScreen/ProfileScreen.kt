package com.definelab.cofeeappusingcompose.presentation.screen.profileScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.GifBox
import androidx.compose.material.icons.filled.Girl
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.definelab.cofeeappusingcompose.presentation.navigation.Routes
import com.definelab.cofeeappusingcompose.presentation.ui.theme.CoffeeBrown
import com.definelab.cofeeappusingcompose.ui_components.BottomNavbar


//@Preview
@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomNavbar(navController,"Profile")
        },
        topBar = {
            ProfileTopBar()
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
//                .fillMaxHeight()
        ) {


            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(110.dp))
                    .background(CoffeeBrown.copy(0.4f))
                    .size(150.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(80.dp)
                        .align(alignment = Alignment.Center),
                    tint = CoffeeBrown
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Akshay",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Akshay123@Gmail.com",
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Address",
                style = MaterialTheme.typography.titleMedium,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Koradi Road,\nVishnu Nagar,\nNagpur 441111 ",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(25.dp))

            Card(modifier = Modifier
//                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = LightGray.copy(0.5f))
//                .background(Color.LightGray.copy(0.6f))
            )
            {
                Column(
                    modifier = Modifier.padding(16.dp)

                ) {

                    Row(modifier = Modifier.fillMaxWidth()
                        .clickable(onClick = {navController.navigate(Routes.CartScreen)}), verticalAlignment = Alignment.CenterVertically ) {

                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Cart",
                            modifier = Modifier
                                .size(28.dp),
                            tint = CoffeeBrown

                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = "Orders",
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Start,
                            fontSize = 18.sp,

                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(modifier = Modifier.fillMaxWidth()
                        .clickable(onClick = {navController.navigate(Routes.FavouriteScreen)}), verticalAlignment = Alignment.CenterVertically ) {

                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favourite",
                            modifier = Modifier
                                .size(28.dp),
                            tint = CoffeeBrown
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = "Favorites",
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Start,
                            fontSize = 18.sp,
                            modifier = Modifier

                        )

                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Cart",
                            modifier = Modifier
                                .size(28.dp),
                            tint = CoffeeBrown

                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = "Notification",
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Start,
                            fontSize = 18.sp,

                            )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

                        Icon(
                            imageVector = Icons.Default.CardGiftcard,
                            contentDescription = "Cart",
                            modifier = Modifier
                                .size(28.dp),
                            tint = CoffeeBrown

                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = "Refer a Friend",
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Start,
                            fontSize = 18.sp,

                            )
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

                        Icon(
                            imageVector = Icons.Default.Help,
                            contentDescription = "Cart",
                            modifier = Modifier
                                .size(28.dp),
                            tint = CoffeeBrown

                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = "Help & Support",
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Start,
                            fontSize = 18.sp,

                            )
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

                        Icon(
                            imageVector = Icons.Default.Logout,
                            contentDescription = "Cart",
                            modifier = Modifier
                                .size(28.dp),
                            tint = CoffeeBrown

                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = "Logout",
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Start,
                            fontSize = 18.sp,

                            )
                    }




                }
            }


        }
    }
}