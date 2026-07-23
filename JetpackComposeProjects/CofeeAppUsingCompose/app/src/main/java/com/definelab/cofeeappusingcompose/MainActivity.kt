package com.definelab.cofeeappusingcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.definelab.cofeeappusingcompose.presentation.navigation.NavGraph
import com.definelab.cofeeappusingcompose.presentation.screen.favouriteScreen.FavouriteScreen
import com.definelab.cofeeappusingcompose.presentation.screen.loginScreen.LoginScreen
import com.definelab.cofeeappusingcompose.presentation.screen.signUpScreen.SignUpScreen

import com.definelab.cofeeappusingcompose.presentation.ui.theme.CofeeAppUsingComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CofeeAppUsingComposeTheme {


//                LoginScreen()
//                            NavGraph()
//                CartScreen()
//                WelcomeScreen()
//                HomeScreen()
//                DetailsScreen()
                SignUpScreen()
            }
        }
    }
}
