package com.definelab.cofeeappusingcompose.presentation.screen.detailScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.definelab.cofeeappusingcompose.presentation.ui.theme.CoffeeBrown
import com.definelab.cofeeappusingcompose.ui_components.AppMessageDialog


@Preview(showBackground = true)
@Composable
fun bottomAppBar() {

    var showCartDialog by remember { mutableStateOf(value = false) }
    BottomAppBar(
        containerColor = Color.Transparent
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(65.dp)
        ) {
            Column() {
                Text(
                    text = "Price",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "$4.53",
                    color = CoffeeBrown,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Button(
                {showCartDialog = true}, modifier = Modifier.size(width = 290.dp, height = 56.dp),
                colors = ButtonDefaults.buttonColors(CoffeeBrown),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "Add To Cart",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Serif
                )

            }

            AppMessageDialog(
                show = showCartDialog,
                title = "Added to Cart",
                message = "Item has been added to cart",
                onDismiss = {showCartDialog=false}

            )
        }


    }
}