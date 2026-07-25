package com.definelab.cofeeappusingcompose.presentation.screen.signUpScreen

import android.R.attr.contentDescription
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.definelab.cofeeappusingcompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpTopAppBar(navController: NavController) {

    TopAppBar(
        title = {

        },
        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.back_arrow),
                contentDescription = "Back Arrow",
                modifier = Modifier.padding(start = 12.dp)
                    .clickable(onClick = {navController.navigateUp()})
            )
        }
    )

}