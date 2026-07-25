package com.definelab.cofeeappusingcompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Composition
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.definelab.cofeeappusingcompose.presentation.screen.cartScreen.CartScreen
import com.definelab.cofeeappusingcompose.presentation.screen.detailScreen.DetailsScreen
import com.definelab.cofeeappusingcompose.presentation.screen.favouriteScreen.FavouriteScreen
import com.definelab.cofeeappusingcompose.presentation.screen.homescreens.HomeScreen
import com.definelab.cofeeappusingcompose.presentation.screen.loginScreen.LoginScreen
import com.definelab.cofeeappusingcompose.presentation.screen.profileScreen.ProfileScreen
import com.definelab.cofeeappusingcompose.presentation.screen.signUpScreen.SignUpScreen
import com.definelab.cofeeappusingcompose.presentation.screen.welcomeScreen.WelcomeScreen

@Composable
fun NavGraph(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.WelcomeScreen){
        composable <Routes.WelcomeScreen>{
            WelcomeScreen(navController)
        }

        composable <Routes.HomeScreen>{
            HomeScreen(navController)
        }

        composable<Routes.DetailScreen> {backSackEntry ->
            val args = backSackEntry.toRoute<Routes.DetailScreen>()
            DetailsScreen(productId = args.productId,navController)

        }

        composable <Routes.CartScreen>{
            CartScreen(navController)
        }

        composable <Routes.FavouriteScreen>{
            FavouriteScreen(navController)
        }

        composable < Routes.ProfileScreen>{
            ProfileScreen(navController)

        }

        composable <Routes.LoginScreen>{
            LoginScreen(navController)
        }

        composable <Routes.SignUpScreen>{
            SignUpScreen(navController)
        }
    }
}