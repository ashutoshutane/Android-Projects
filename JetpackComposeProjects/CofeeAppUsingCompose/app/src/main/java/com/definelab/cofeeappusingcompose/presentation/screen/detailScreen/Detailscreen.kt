package com.definelab.cofeeappusingcompose.presentation.screen.detailScreen


import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.definelab.cofeeappusingcompose.R
import com.definelab.cofeeappusingcompose.model.Product


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsScreen(productId:Int,navController: NavController) {


    val productList = listOf<Product>(
        Product(1, "Espresso", "Rich, Thick and Strong Coffee", 5.0, R.drawable.coffee1),
        Product(2, "Cappuccino", "Creamy Milk Foam with Espresso", 4.8, R.drawable.coffee2),
        Product(3, "Latte", "Smooth Coffee with Steamed Milk", 4.7, R.drawable.coffee3),
        Product(4, "Americano", "Bold Espresso Diluted with Water", 4.6, R.drawable.coffee4),
        Product(5, "Mocha", "Chocolate Flavored Coffee Delight", 4.9, R.drawable.coffee5),
        Product(6, "Cold Brew", "Slow Brewed and Refreshingly Cold", 4.8, R.drawable.coffee6),
        Product(7, "Macchiato", "Espresso Topped with Milk Foam", 4.7, R.drawable.coffee7),
        Product(8, "Flat White", "Velvety Microfoam and Espresso", 4.5, R.drawable.coffee8),
        Product(9, "Irish Coffee", "Coffee with Creamy Sweet Flavor", 4.6, R.drawable.coffee9),
        Product(10, "Affogato", "Vanilla Ice Cream with Espresso Shot", 4.9, R.drawable.coffee10)

    )

    var selectedProduct = productList.find { it.proId == productId}

    if(selectedProduct==null){
        Text("Product not Found!", color = Color.Red)
        return
    }

    Scaffold(
        topBar = { DsTopAppBar(navController) },
        bottomBar = { bottomAppBar() }
    ) { innerPadding->

        LazyColumn() {
            item {
                ProductDetailContent(selectedProduct,innerPadding)
            }
        }
    }
}