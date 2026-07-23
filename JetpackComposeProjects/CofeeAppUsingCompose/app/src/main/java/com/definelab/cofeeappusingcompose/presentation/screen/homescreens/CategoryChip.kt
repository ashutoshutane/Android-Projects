package com.definelab.cofeeappusingcompose.presentation.screen.homescreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.definelab.cofeeappusingcompose.presentation.ui.theme.CoffeeBrown


@Composable
fun CategoryChip(
    text:String,
    isSelected: Boolean,
    onSelected: ()-> Unit
){
    Box(modifier = Modifier
//        .wrapContentWidth(align = Alignment.CenterHorizontally)
        .width(90.dp)
        .height(30.dp)
        .clip(shape = RoundedCornerShape(30))
        .clickable{onSelected()}
//        .padding(vertical = 8.dp, horizontal = 4.dp)
        .background(color = if(isSelected) CoffeeBrown else Color.LightGray),
        contentAlignment = Alignment.Center){
        Text(text=text,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Serif,
            maxLines = 1,
            color = if(isSelected) Color.White else Color.Black,
            )

    }

}

@Preview(showBackground = true)
@Composable
fun CategoryChipPreview(){
    CategoryChip(
        text = "All Coffee",
        isSelected = true,
        onSelected = {}
    )
}