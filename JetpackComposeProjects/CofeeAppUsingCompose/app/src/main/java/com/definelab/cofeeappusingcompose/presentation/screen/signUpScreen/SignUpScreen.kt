package com.definelab.cofeeappusingcompose.presentation.screen.signUpScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.definelab.cofeeappusingcompose.R
import com.definelab.cofeeappusingcompose.presentation.ui.theme.CoffeeBrown
import com.definelab.cofeeappusingcompose.presentation.ui.theme.Typography

@Composable
@Preview
fun SignUpScreen(){
    var Email by remember { mutableStateOf("") }
    var confPassword by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }
    var Password by remember { mutableStateOf("") }
    Scaffold() {innerPadding->

        Column(Modifier.padding(innerPadding)
            .padding(16.dp)
            .fillMaxSize()) {

             Text(text = "Sign Up",
                 style = Typography.titleLarge,
                 fontWeight = FontWeight.SemiBold,
                 fontFamily = FontFamily.SansSerif
             )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Email",
                style = Typography.titleMedium,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(6.dp))

            OutlinedTextField(
                value = Email,
                onValueChange = {Email = it},
                label = {Text("Username")},
                placeholder = {Text("Enter the password")},
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color.LightGray,
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.LightGray),
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Password",
                style = Typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif
            )

            Spacer(modifier = Modifier.height(6.dp))

            OutlinedTextField(
                value = Password,
                onValueChange = {Password = it},
                label = {Text("Password")},
                placeholder = {Text("Enter the password")},
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color.LightGray,
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.LightGray),
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Confirm Password",
                style = Typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif
            )

            Spacer(modifier = Modifier. height(6.dp))

            OutlinedTextField(
                value = confPassword,
                onValueChange = {confPassword = it},
                label = {Text("Confirm Password")},
                placeholder = {Text("Enter the password")},
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color.LightGray,
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.LightGray),
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(20.dp))


            Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    modifier = Modifier.size(20.dp),
                    checked = isChecked,
                    onCheckedChange = {isChecked = it}
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "I Accept the privacy policy\nand Terms of Use")
            }

            Spacer(modifier = Modifier.height(10.dp))



            Button(onClick = {}, modifier = Modifier.fillMaxWidth()
                .padding(10.dp),
                colors = ButtonDefaults.buttonColors(CoffeeBrown)){

                Text(text = "Sign up",
                    fontSize = 18.sp
                )
            }

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    thickness = 2.dp
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(text = "OR")

                Spacer(modifier = Modifier.width(10.dp))
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    thickness = 2.dp
                )
            }

            Button(onClick = {}, modifier = Modifier.fillMaxWidth()
                .padding(16.dp),
                colors = ButtonDefaults.buttonColors(Color.LightGray)){

                Text(text = "Continue with Email",
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }

            Button({},
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                modifier = Modifier.fillMaxWidth()
                    .height(40.dp).padding(start = 15.dp, end = 15.dp)) {
                Image(painter = painterResource(R.drawable.google),
                    contentDescription = "Google")
                Spacer(modifier = Modifier.width(30.dp))
                Text(text = "Continue with Google",
                    color = Color.Black,
                    fontSize = 18.sp)

            }

            Spacer(modifier = Modifier.height(10.dp))

       

        }
    }
}