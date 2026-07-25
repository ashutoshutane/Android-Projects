package com.definelab.cofeeappusingcompose.presentation.screen.welcomeScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.definelab.cofeeappusingcompose.R
import com.definelab.cofeeappusingcompose.presentation.navigation.Routes
import com.definelab.cofeeappusingcompose.presentation.ui.theme.CoffeeBrown


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(navController: NavController) {

    var showBottomSheet by remember() { mutableStateOf(false) }

    val sheetState = rememberModalBottomSheetState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(R.drawable.image_splash),
            contentDescription = "Welcome Image"
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 70.dp, start = 15.dp, end = 15.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Fall in Love with Coffee in Blissfull Delight!",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Serif
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Good days Start with great coffee. Let's get brewing",
            color = Color.White,
            fontWeight = FontWeight.Thin,
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Serif
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            {
                showBottomSheet = true
                //navController.navigate(Routes.HomeScreen)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(CoffeeBrown),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(3.dp, color = Color.White)
        ) {
            Text(
                text = "Get Started",
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

        }
        if (showBottomSheet) {

            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState,
                containerColor = Color.White
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    Text(
                        text = "Welcome",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Button(
                        onClick = {

                           navController.navigate(Routes.LoginScreen)

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF8B5E3C)
                        )
                    ) {

                        Icon(Icons.Outlined.Email, null)

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text("Continue with Email")
                    }

                    Button(
                        onClick = {

                            // Google Login

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFF5F5F5),
                            contentColor = Color.Black
                        )
                    ) {

                        Text("Continue with Google")
                    }

                    HorizontalDivider()

                    Button(
                        onClick = {

                            navController.navigate(Routes.SignUpScreen)

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.Black
                        )
                    ) {

                        Icon(Icons.Outlined.Person, null)

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text("Create Account")
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }


    }
}