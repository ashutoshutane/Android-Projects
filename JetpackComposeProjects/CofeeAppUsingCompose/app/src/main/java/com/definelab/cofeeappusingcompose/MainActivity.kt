package com.definelab.cofeeappusingcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.definelab.cofeeappusingcompose.data.remote.FirebaseRepository
import com.definelab.cofeeappusingcompose.presentation.navigation.NavGraph
import com.definelab.cofeeappusingcompose.presentation.screen.favouriteScreen.FavouriteScreen
import com.definelab.cofeeappusingcompose.presentation.screen.loginScreen.LoginScreen
import com.definelab.cofeeappusingcompose.presentation.screen.signUpScreen.SignUpScreen

import com.definelab.cofeeappusingcompose.presentation.ui.theme.CofeeAppUsingComposeTheme
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CofeeAppUsingComposeTheme {


//                LoginScreen()
                            NavGraph()
//                CartScreen()
//                WelcomeScreen()
//                HomeScreen()
//                DetailsScreen()
//                SignUpScreen()
            }

            Log.d("Firebase",
                FirebaseRepository.auth.toString())

            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(
                    "test123@gmail.com",
                    "12345678"
                )
                .addOnSuccessListener {
                    Log.d("FirebaseTest","Signup Success")
                }
                .addOnFailureListener {
                    Log.e("FirebaseTest",it.message.toString())
                }
        }
    }
}
