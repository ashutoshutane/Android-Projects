package com.definelab.cofeeappusingcompose.presentation.screen.homescreens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.definelab.cofeeappusingcompose.model.Product


@Composable
fun ProductGrid(
    product: List<Product>,
    navController: NavController,
    topContent: @Composable () -> Unit,
){

    LazyColumn(modifier = Modifier.fillMaxSize().padding(8.dp)) {

        item { topContent() }


        items(product.chunked(2)){product ->

            Row(modifier = Modifier.fillMaxWidth()) {
                ProductCard(product = product[0],
                    modifier = Modifier.weight(1f),
                    navController = navController
                )
                if(product.size == 2){
                    ProductCard(product = product[1],
                        modifier = Modifier.weight(1f),
                        navController = navController)
                }else{
                    Spacer(modifier = Modifier.weight(1f))
                }

            }



        }
    }

}