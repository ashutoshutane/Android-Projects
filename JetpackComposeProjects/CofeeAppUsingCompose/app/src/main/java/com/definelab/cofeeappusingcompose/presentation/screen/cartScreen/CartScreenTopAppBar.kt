@file:OptIn(ExperimentalMaterial3Api::class)

package com.definelab.cofeeappusingcompose.presentation.screen.cartScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController

//@Preview
@Composable
fun CartScreenTopBar(navController: NavController){
    TopAppBar(
        title = {
            Text(
                text = "Orders",
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,

                modifier = Modifier.fillMaxWidth()
            )
        },

//        navigationIcon = {
//            Icon(
//                painter = painterResource(R.drawable.back_arrow),
//                contentDescription = "BAck Arrow",
//                modifier = Modifier.padding(start = 12.dp)
//                    .clickable(onClick = {navController.navigateUp()})
//            )
//        }
    )
}