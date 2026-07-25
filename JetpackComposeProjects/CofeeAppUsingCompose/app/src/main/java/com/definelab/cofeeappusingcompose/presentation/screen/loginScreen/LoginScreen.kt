package com.definelab.cofeeappusingcompose.presentation.screen.loginScreen



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.lightColorScheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.definelab.cofeeappusingcompose.R
import com.definelab.cofeeappusingcompose.presentation.ui.theme.CoffeeBrown
import com.definelab.cofeeappusingcompose.presentation.ui.theme.Typography


//@Preview
@Composable
fun LoginScreen(navController: NavController) {

    var Email by remember { mutableStateOf("") }
    var Password by remember { mutableStateOf("") }

    Scaffold(){innerPadding->

        Column(modifier = Modifier.fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)) {

            Text(
                text = "Log in",
                style = Typography.titleLarge,
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Email",
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                style = Typography.titleMedium
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = Email,
                onValueChange = {Email = it},
                label = {Text("Username")},
                placeholder = {Text("Enter the password")},
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color.LightGray,
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.LightGray)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Password",
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                style = Typography.titleMedium
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = Password,
                onValueChange = {Password = it},
                label = {Text("Password")},
                placeholder = {Text("Enter the username")},
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color.LightGray,
                    focusedLabelColor = Color.LightGray,
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.LightGray
                    ),
                )

            Spacer(modifier = Modifier.height(25.dp))

            Button({},
                modifier = Modifier.fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(CoffeeBrown)) {
                Text(
                    text = "Log in",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = Typography.titleSmall
                )

            }

            Spacer(modifier = Modifier.height(15.dp))

            Text(text = "Forget Password ?",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold)

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    thickness = 2.dp
                )

                Text(
                    text = " OR ",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(horizontal = 9.dp)
                )

                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    thickness = 2.dp
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button({},
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                modifier = Modifier.fillMaxWidth()
                    .height(50.dp)) {
                Text(text = "Continue with Email",
                    color = Color.Black,
                    fontSize = 20.sp)

            }

            Spacer(modifier = Modifier.height(20.dp))

            Button({},
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                modifier = Modifier.fillMaxWidth()
                    .height(50.dp)) {
                Image(painter = painterResource(R.drawable.google),
                    contentDescription = "Google")
                Spacer(modifier = Modifier.width(30.dp))
                Text(text = "Continue with Google",
                    color = Color.Black,
                    fontSize = 20.sp)

            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = "Don't have an Account?",
                    color = Color.Black,
                    fontSize = 15.sp)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Sign Up",
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold)
            }

        }


    }
}