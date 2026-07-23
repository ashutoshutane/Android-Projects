package com.definelab.cofeeappusingcompose.presentation.screen.detailScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.definelab.cofeeappusingcompose.R

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun DsTopAppBar(navController: NavController) {

    TopAppBar(
        title = {
            Text(
                text = "Details",
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,

                modifier = Modifier.fillMaxWidth()
            )
        },
        actions = {
            Icon(
                painter = painterResource(R.drawable.favorite_icon),
                contentDescription = "Favorite",
                modifier = Modifier.padding(end = 12.dp)
            )

        },

        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.back_arrow),
                contentDescription = "BAck Arrow",
                modifier = Modifier.padding(start = 12.dp)
                    .clickable(onClick = {navController.navigateUp()})
            )
        }
    )


}