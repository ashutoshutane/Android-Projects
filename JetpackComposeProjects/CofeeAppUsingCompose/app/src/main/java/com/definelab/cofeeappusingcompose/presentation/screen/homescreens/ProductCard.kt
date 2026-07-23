package com.definelab.cofeeappusingcompose.presentation.screen.homescreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.definelab.cofeeappusingcompose.R
import com.definelab.cofeeappusingcompose.model.Product
import com.definelab.cofeeappusingcompose.presentation.navigation.Routes
import com.definelab.cofeeappusingcompose.presentation.ui.theme.CoffeeBrown
import com.definelab.cofeeappusingcompose.presentation.ui.theme.Lightbrown


//@Preview(showBackground = true)
@Composable
fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable{navController.navigate(Routes.DetailScreen(product.proId) )},
    ) {
        Column() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
            ) {
                Image(
                    painter = painterResource(product.imageRes),
                    contentDescription = "Product Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(all = 10.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(14.dp)
                        .background(Color.LightGray.copy(0.8f),
                            shape = RoundedCornerShape(8.dp))
                        .size(30.dp)

                ) {
                    IconButton({}) {
                        Icon(
                            painter = painterResource(R.drawable.favorite_icon),
                            contentDescription = "Add To Favourite",
                            tint = Lightbrown,
                            modifier = Modifier.size(20.dp)

                        )
                    }
                }
            }

            Text(
                text = product.proName,
                style = MaterialTheme.typography.titleMedium.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier.padding(start = 12.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = product.proDescription,
                style = MaterialTheme.typography.bodySmall.copy(
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(start = 12.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(60.dp)
            ) {
                Text(
                    text = "${product.proPrice} $",
                    modifier = Modifier.padding(start = 12.dp),
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = CoffeeBrown
                    ),
                )

                IconButton(
                    {},
                    modifier = Modifier
                        .size(100.dp)

                ) {
                    Icon(
                        painter = painterResource(R.drawable.add_to_cart),
                        contentDescription = "Add To Cart",
                        tint = CoffeeBrown,
                        modifier = Modifier.size(100.dp)
                    )
                }

            }
        }

    }
}

