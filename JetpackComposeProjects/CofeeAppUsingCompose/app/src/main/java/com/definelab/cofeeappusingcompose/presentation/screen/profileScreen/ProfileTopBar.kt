package com.definelab.cofeeappusingcompose.presentation.screen.profileScreen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTopBar(){

    TopAppBar(
        title = {
            Text(
                text = "Profile",
                fontWeight = FontWeight.Bold
            )
        }
    )

}