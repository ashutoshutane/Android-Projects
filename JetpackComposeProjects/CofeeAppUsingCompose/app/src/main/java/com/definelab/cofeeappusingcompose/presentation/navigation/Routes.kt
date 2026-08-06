package com.definelab.cofeeappusingcompose.presentation.navigation

import com.definelab.cofeeappusingcompose.model.Product
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable


sealed class Routes {

    @Serializable
    object WelcomeScreen: Routes(){

    }

    @Serializable
    object HomeScreen: Routes(){

    }

    @Serializable
    data class DetailScreen(val productId : String) : Routes()

    @Serializable
    object CartScreen: Routes()

    @Serializable
    object FavouriteScreen:Routes()

    @Serializable
    object ProfileScreen: Routes()

    @Serializable
    object LoginScreen: Routes()

    @Serializable
    object SignUpScreen: Routes()
}

