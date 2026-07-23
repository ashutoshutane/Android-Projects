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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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


@Composable
fun WelcomeScreen(navController: NavController) {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
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
            {navController.navigate(Routes.HomeScreen)},
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
    }


}