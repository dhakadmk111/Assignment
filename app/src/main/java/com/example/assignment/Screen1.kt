package com.example.assignment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Screen1(navController: NavController) {
    var buttonText by rememberSaveable { mutableStateOf<List<String>>(listOf()) }
    var value = 1100

    LazyColumn {
        items(buttonText) {
            Text(
                text = it.toString(),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp),
                textAlign = TextAlign.Center
            )
        }
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = AbsoluteAlignment.Left
    ) {
        Row {
            Button(onClick = { navController.navigate("Screen2") }) {
                Text(text = "2")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { navController.navigate("Screen3") }) {
                Text(text = "3")
            }
            Spacer(modifier = Modifier.width(110.dp))
            Button(onClick = {
                val list = buttonText.toMutableList()
                value -= 100
                val a = if (value % 200 == 0) {
                    value.toString()
                } else {
                    "-".plus(value.toString())
                }
                list.add(a)
                buttonText = list

            }) {
                Text(text = "Button")
            }
        }
    }
}