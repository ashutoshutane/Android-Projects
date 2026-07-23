package com.definelab.cofeeappusingcompose.presentation.screen.detailScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.definelab.cofeeappusingcompose.R
import com.definelab.cofeeappusingcompose.model.Product
import com.definelab.cofeeappusingcompose.presentation.ui.theme.CoffeeBrown

@Composable
fun ProductDetailContent(product: Product,innerPadding: PaddingValues){


    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()
        .padding(innerPadding)) {
        Image(
            painter = painterResource(product.imageRes),
            contentDescription = product.proName,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(shape = RoundedCornerShape(16.dp))
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
                text = product.proName,
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Serif
            )

        Spacer(modifier = Modifier.height(15.dp))
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Ice/Hot",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Serif,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.weight(1f))


            Icon(
                painter = painterResource(R.drawable.default_bean),
                contentDescription = "Bean",
                tint = CoffeeBrown,
                modifier = Modifier.background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(10.dp)
                )
                    .size(36.dp)
                    .padding(6.dp)



            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        HorizontalDivider(color = Color.LightGray.copy(alpha = 0.5f))

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Description",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Serif
        )
        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = product.proDescription,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Serif,
            color = Color.Gray
        )


        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Size",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Serif
        )
        Spacer(modifier = Modifier.height(15.dp))

        var selectedSizeText by remember { mutableStateOf("M") }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ){
            listOf("S","M","L").forEach { size->
                SelectSizeChip(
                    sizeText = size,
                    selected = selectedSizeText == size,
                    onClick = {selectedSizeText = size},
                    Modifier.weight(1f).height(46.dp)

                )
            }

        }
        }

}