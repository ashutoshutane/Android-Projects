package com.definelab.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.definelab.layouts.ui.theme.LayoutsTheme

class MainActivity : ComponentActivity() {
    //this is for the Emulator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    //MyLayouts(name = "Android")
//                    MyAlingments()
                    Componenets()
                }
            }
        }
    }
}


//function which we created

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {


}

@Composable
fun MyLayouts(name: String, modifier: Modifier = Modifier) {
    Column() {
        Box(
            Modifier
                .background(Color.Green)
                .height(200.dp)
                .width(300.dp)
                .size(200.dp, 300.dp)
        ) {

            Row() {
                Box(
                    Modifier
                        .size(50.dp)
                        .background(Color.Cyan)
                )
                Column() {
                    Text(text = "Hello")
                    Text(text = "$name!")
                }
            }
        }


    }
}

//Android Components
//button
@Composable
@Preview(showBackground = true)
fun Componenets() {

    val backgroundColor = remember {
        mutableStateOf(Color.Yellow)
    }

    val buttonText = remember {
        mutableStateOf("Click Me")
    }

    val buttonTextColor = remember {
        mutableStateOf(Color.Black)
    }

    val myText = remember {
        mutableStateOf("Welcome to kotlin!")
    }

    val myTextColor = remember {
        mutableStateOf(Color.Black)
    }

    val myTextBackgroundColor = remember {
        mutableStateOf(Color.Cyan)
    }

    val isClicked = remember {
        mutableStateOf(true)
    }

    val valueOnTextField = remember {
        mutableStateOf("")
    }

    val userInput = remember {
        mutableStateOf("Result : ")
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (isClicked.value) {
            Text(
                text = myText.value,
                color = myTextColor.value,
                fontSize = 25.sp,
                modifier = Modifier
                    .background(
                        myTextBackgroundColor.value,
                        shape = RoundedCornerShape(10.dp),
                    )
                    .border(2.dp, Color.Black, shape = RoundedCornerShape(10.dp))
                    .padding(20.dp),
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
            )
        }



        Spacer(modifier = Modifier.size(30.dp))

        Button(

            {
                //button
//                backgroundColor.value = Color.Cyan
//                buttonText.value = "Welcome to Android!"
//                buttonTextColor.value = Color.Red
//                //Text
//                myText.value = "Android is Fun!"
//                myTextColor.value = Color.Black
//                myTextBackgroundColor.value = Color.Yellow

                if (isClicked.value) {
                    backgroundColor.value = Color.Cyan
                    buttonText.value = "Welcome to Android!"
                    buttonTextColor.value = Color.Red
                    //Text
                    myText.value = "Android is Fun!"
                    myTextColor.value = Color.Black
                    myTextBackgroundColor.value = Color.Yellow

                    isClicked.value = false
                } else {
                    backgroundColor.value = Color.Yellow
                    buttonText.value = "Click Me"
                    buttonTextColor.value = Color.Black

                    myText.value = "Welcome To Kotlin!"
                    myTextColor.value = Color.Red
                    myTextBackgroundColor.value = Color.Yellow

                    isClicked.value = true
                }
                userInput.value = valueOnTextField.value
                valueOnTextField.value = " "

            },
            modifier = Modifier.size(250.dp, 60.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor.value),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(2.dp, Color.Black)
        ) {
            Text(
                text = buttonText.value,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = buttonTextColor.value,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.ExtraBold,
            )
        }

        Spacer(Modifier.size(30.dp))

        TextField(
            valueOnTextField.value,
            onValueChange = {
                valueOnTextField.value = it
            },
            label = {
                Text(
                    text = "Enter your Name",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                )
            },
            modifier = Modifier.width(300.dp),
            colors = TextFieldDefaults.colors(Color.Red,
                focusedLabelColor = Color.Yellow,
                unfocusedLabelColor = Color.White,
                unfocusedIndicatorColor = Color.Red,
                focusedIndicatorColor = Color.Green
                ),
            textStyle = TextStyle.Default.copy(fontSize = 20.sp),
            maxLines = 4,
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            visualTransformation = PasswordVisualTransformation
        )

        Spacer(Modifier.size(30.dp))

        Text(
            text = userInput.value,
            color = myTextColor.value,
            fontSize = 25.sp,
            modifier = Modifier
                .background(
                    myTextBackgroundColor.value,
                    shape = RoundedCornerShape(10.dp),
                )
                .border(2.dp, Color.Black, shape = RoundedCornerShape(10.dp))
                .padding(20.dp),
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
        )
    }
}


// Android Layouts
@Composable
//@Preview(showBackground = true)
fun MyAlingments() {


    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Hello",
            color = Color.White,
            modifier = Modifier
                .background(Color.Red)
                .width(100.dp),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
        )

        Text(
            text = "Welcome",
            color = Color.White,
            modifier = Modifier
                .background(Color.Red)
                .width(100.dp),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
        )

        Text(
            text = "To",
            color = Color.White,
            modifier = Modifier
                .background(Color.Red)
                .width(50.dp),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
        )

        Text(
            text = "Android!",
            color = Color.White,
            modifier = Modifier
                .background(Color.Red)
                .width(150.dp),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
        )

    }

}


//this is for preview
//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LayoutsTheme {
//        Greeting("Android")
        //  MyLayouts(name = "Android")
        MyAlingments()
    }
}