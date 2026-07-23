 package com.definelab.cofeeappusingcompose.presentation.screen.cartScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.definelab.cofeeappusingcompose.R
import com.definelab.cofeeappusingcompose.presentation.ui.theme.CoffeeBrown
import com.definelab.cofeeappusingcompose.presentation.ui.theme.Lightbrown

//@Preview
@Composable
fun PaymentModeSelect(totalAmount: Double) {
    Spacer(modifier = Modifier.height(16.dp))

    var expanded by remember {
        mutableStateOf(false)
    }

    var selectedMode by remember { mutableStateOf("Online") }

    val paymentmodes = listOf("Online","Cash")

    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(19.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = if( selectedMode =="Online") painterResource(R.drawable.mobile_banking) else
                        painterResource(R.drawable.wallet),
                    contentDescription = "mobile banking",
                    modifier = Modifier.size(30.dp),
                    tint = CoffeeBrown
                )

                Spacer(modifier = Modifier.width(10.dp))

                Column() {
                    Text(
                        text = selectedMode,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    if(selectedMode == "Online") {
                        Text(
                            text = "$ ${totalAmount}",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = CoffeeBrown
                        )
                    }else{
                        Text(
                            text = "$ ${totalAmount + 1}",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = CoffeeBrown
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(0.1f))

                Box() {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Change payment Mode",
                        modifier = Modifier.size(22.dp).clickable{expanded = true}
                    )

                    DropdownMenu(expanded = expanded,
                        onDismissRequest = {expanded = false}) {
                        paymentmodes.forEach { modes ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = modes,
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                },
                                onClick = {selectedMode = modes
                                    expanded = false},
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(if(modes=="Online") R.drawable.mobile_banking
                                        else R.drawable.wallet),
                                        contentDescription = "Paymade Mode",
                                        tint = Lightbrown,
                                        modifier = Modifier.size(24.dp)
                                    )

                                },
                                modifier = Modifier.background(color = if(selectedMode == modes) Lightbrown.copy(alpha = 0.15f) else
                                    Color.Transparent)


                            )
                        }

                    }
                }

            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                {}, modifier = Modifier
              .fillMaxWidth()
              .height(50.dp),
                shape = RoundedCornerShape(15),
                colors = ButtonDefaults.buttonColors(CoffeeBrown)
            ) {
                Text(
                    text = "Place Order",
                    fontSize = 20.sp
                )

            }

        }
    }
}