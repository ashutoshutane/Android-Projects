package com.definelab.cofeeappusingcompose.presentation.screen.favouriteScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.definelab.cofeeappusingcompose.R
import com.definelab.cofeeappusingcompose.model.Product
import com.definelab.cofeeappusingcompose.presentation.screen.cartScreen.CartItemCard
import com.definelab.cofeeappusingcompose.presentation.screen.detailScreen.bottomAppBar
import com.definelab.cofeeappusingcompose.ui_components.BottomNavbar

//@Preview
@Composable
fun FavouriteScreen(navController: NavController){
    val wishlistProductList = listOf<Product>(
        Product("1", "Espresso", "Rich, Thick and Strong Coffee", 5.0, R.drawable.coffee1),
        Product("2", "Cappuccino", "Creamy Milk Foam with Espresso", 4.8, R.drawable.coffee2),
        Product("3", "Latte", "Smooth Coffee with Steamed Milk", 4.7, R.drawable.coffee3),
    )

    Scaffold(
        bottomBar = { BottomNavbar(navController,"Favourites") }
    )
    {innerPadding ->
        
        LazyColumn(modifier = Modifier
            .padding(16.dp)
            .padding(innerPadding)) {

            item {
               Text(text = "WishList",
                   fontFamily = FontFamily.Serif,
                   fontWeight = FontWeight.SemiBold,
                   fontSize = 25.sp,
                   modifier = Modifier.padding(top = 16.dp)
               )
                Spacer(modifier = Modifier.height(5.dp))
                wishlistProductList.forEach { product ->
                    Spacer(modifier = Modifier.height(15.dp))
                    FavouriteItemCard(product)
                }
            }

        }
    }
}