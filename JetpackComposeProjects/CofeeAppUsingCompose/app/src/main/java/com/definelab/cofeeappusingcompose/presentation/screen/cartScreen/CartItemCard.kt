package com.definelab.cofeeappusingcompose.presentation.screen.cartScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.definelab.cofeeappusingcompose.model.Product
import com.definelab.cofeeappusingcompose.presentation.ui.theme.CoffeeBrown


@Composable
fun CartItemCard(product: Product){

    var quantity by remember { mutableStateOf(1) }
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = LightGray,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(modifier = Modifier.fillMaxWidth().padding(12.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(product.imageRes),
                contentDescription = "Coffee Image",
                modifier = Modifier
                    .size(60.dp)
                    .clip(shape = RoundedCornerShape(12.dp))
                )

            Spacer(modifier = Modifier.width(10.dp))

            Column() {
                Text(
                    text = product.proName,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif,
                    )
                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = product.proDescription,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.width(150.dp)

                )


            }

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically) {
                IconButton({if(quantity>0)quantity--}) {
                    Icon(
                        imageVector = Icons.Default.Remove,
                        contentDescription = "Remove",
                        modifier = Modifier
                            .background(color = CoffeeBrown.copy(alpha = 0.2f),
                                shape = RoundedCornerShape(100))
                            .padding(3.dp),
                        tint = CoffeeBrown
                    )

                }

                Text(
                    text = quantity.toString(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold)

                IconButton({quantity++}) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        modifier = Modifier
                            .background(color = CoffeeBrown.copy(alpha = 0.2f),
                                shape = RoundedCornerShape(100))
                            .padding(3.dp),
                        tint = CoffeeBrown
                    )

                }
            }

        }

    }

}