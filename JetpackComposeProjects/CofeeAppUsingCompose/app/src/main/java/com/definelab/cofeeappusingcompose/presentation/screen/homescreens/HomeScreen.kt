package com.definelab.cofeeappusingcompose.presentation.screen.homescreens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.definelab.cofeeappusingcompose.R
import com.definelab.cofeeappusingcompose.model.Product
import com.definelab.cofeeappusingcompose.ui_components.BottomNavbar


@Composable
fun HomeScreen(navController: NavController) {

    var location = "Nagpur Maharashtra"

    Scaffold(
        bottomBar = { BottomNavbar(navController,"Home") }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f / 3f)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF303030),
                            Color(0xFF1F1F1F),
                            Color(0xFF121212)
                        )
                    )
                )
        )

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, top =16.dp, end = 16.dp)
            .padding(innerPadding)) {


            val productList = listOf<Product>(
                Product(1,"Espresso","Rich, Thick and Strong Coffee",5.0,R.drawable.coffee1),
                Product(2,"Cappuccino","Creamy Milk Foam with Espresso",4.8,R.drawable.coffee2),
                Product(3,"Latte","Smooth Coffee with Steamed Milk",4.7,R.drawable.coffee3),
                Product(4,"Americano","Bold Espresso Diluted with Water",4.6,R.drawable.coffee4),
                Product(5,"Mocha","Chocolate Flavored Coffee Delight",4.9,R.drawable.coffee5),
                Product(6,"Cold Brew","Slow Brewed and Refreshingly Cold",4.8,R.drawable.coffee6),
                Product(7,"Macchiato","Espresso Topped with Milk Foam",4.7,R.drawable.coffee7),
                Product(8,"Flat White","Velvety Microfoam and Espresso",4.5,R.drawable.coffee8),
                Product(9,"Irish Coffee","Coffee with Creamy Sweet Flavor",4.6,R.drawable.coffee9),
                Product(10,"Affogato","Vanilla Ice Cream with Espresso Shot",4.9,R.drawable.coffee10)

            )
            
            ProductGrid(productList,navController = navController) {
                Text(

                    text = "Location",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Serif
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = location,
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Change Location",
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                SearchBar()

                Spacer(modifier = Modifier.height(10.dp))

                Image(
                    painter = painterResource(R.drawable.banner6),
                    contentDescription = "Banner",
                    modifier = Modifier.fillMaxWidth().height(180.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                HomeScreenCategories()
            }


        }




    }

}