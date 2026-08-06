package com.definelab.cofeeappusingcompose.presentation.screen.cartScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.definelab.cofeeappusingcompose.R
import com.definelab.cofeeappusingcompose.model.Product
import com.definelab.cofeeappusingcompose.presentation.ui.theme.CoffeeBrown
import com.definelab.cofeeappusingcompose.ui_components.BottomNavbar


//@Preview
@Composable
fun CartScreen(navController: NavController) {
    val cartProductList = listOf<Product>(
        Product("1", "Espresso", "Rich, Thick and Strong Coffee", 5.0, R.drawable.coffee1),
        Product("2", "Cappuccino", "Creamy Milk Foam with Espresso", 4.8, R.drawable.coffee2),
        Product("3", "Latte", "Smooth Coffee with Steamed Milk", 4.7, R.drawable.coffee3),
    )

    var amount by remember { mutableDoubleStateOf(12.50) }
    var deliveryFee by remember { mutableDoubleStateOf(1.0) }
    var totalamount = amount+deliveryFee
    Scaffold(
        topBar = { CartScreenTopBar(navController) },
        bottomBar = { BottomNavbar(navController = navController, "Cart") }

        ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .padding(innerPadding)
        ) {
            item {
                Row() {
                    Text(
                        text = "Deliver",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = CoffeeBrown,
                        fontFamily = FontFamily.SansSerif
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))
                cartProductList.forEach { product ->
                    Spacer(modifier = Modifier.height(15.dp))
                    CartItemCard(product)
                }

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = "Payment Summary",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.SemiBold
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row() {
                    Text(
                        text = "Price",
                        fontFamily = FontFamily.SansSerif,
                    )
                    Spacer(modifier = Modifier.weight(0.1f))
                    Text(text = "$ ${amount}")
                }

                Spacer(modifier = Modifier.height(8.dp))


                Row() {
                    Text(text = "Delivery Fee")
                    Spacer(modifier = Modifier.weight(0.1f))
                    Text(text = "$ ${deliveryFee}")
                }


                PaymentModeSelect(totalamount)

            }
        }
    }
}