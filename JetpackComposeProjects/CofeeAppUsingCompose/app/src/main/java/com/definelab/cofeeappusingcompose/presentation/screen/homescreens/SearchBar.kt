package com.definelab.cofeeappusingcompose.presentation.screen.homescreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.definelab.cofeeappusingcompose.R
import com.definelab.cofeeappusingcompose.presentation.ui.theme.CoffeeBrown

@Preview(showBackground = true)
@Composable
fun SearchBar() {
    var searchText by remember {
        mutableStateOf("")
    }
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            placeholder = { Text(text = "Search Coffee" , color = Color.Gray) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.Gray
                )
            },
            shape = RoundedCornerShape(16.dp, 0.dp,
                0.dp, 16.dp),
            singleLine = true,
            modifier = Modifier.weight(1f).height(56.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color(0xFF2A2A2A),
                focusedContainerColor = Color(0xFF422A24),
                cursorColor = Color.LightGray,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.Gray



            )

        )
        Spacer(modifier = Modifier.width(4.dp))
        IconButton(
            onClick = {}, modifier = Modifier.background(
                color = CoffeeBrown, shape = RoundedCornerShape(0.dp,
                    16.dp, 16.dp)
            )
                .height(56.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.filter),
                contentDescription = "Filter",
                modifier = Modifier.size(25.dp),
                tint = Color.White
            )
        }


    }

}