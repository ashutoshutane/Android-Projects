package com.definelab.cofeeappusingcompose.presentation.screen.homescreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun HomeScreenCategories(){


    val categories  =  listOf(
        "All Coffee",
        "Espresso ",
        "Americano",
        "Red Eye",
        "Latte",
        "Cappuccino",
        "Flat White",
        "Cortado",
        "Macchiato",
        "Mocha",
        "Drip Coffee",
        "Café au Lait",
        "Iced Coffee",
        "Cold Brew",
        "Frappé",
        "Affogato",
        "Irish Coffee"
    )

    var selectedCategory by remember{ mutableStateOf(categories.first()) }

    LazyRow(modifier = Modifier.padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        items(categories){ category->
            CategoryChip(
                text = category,
                isSelected = category == selectedCategory,
                onSelected = {selectedCategory = category}
            )
        }


    }
}