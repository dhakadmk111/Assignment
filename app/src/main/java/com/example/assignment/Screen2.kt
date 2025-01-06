package com.example.assignment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun Screen2(navController: NavController){
    var series by rememberSaveable { mutableStateOf<List<Int>>(listOf()) }
    var cur = 0
    var next = 1

    LazyRow (
        contentPadding = PaddingValues(2.dp)
    ){
        items(series) {
            Text(
                text = it.toString(),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(3.dp),
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
            Button(onClick = { navController.navigate("Screen1") }) {
                Text(text = "1")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { navController.navigate("Screen3") }) {
                Text(text = "3")
            }
            Spacer(modifier = Modifier.width(110.dp))
            Button(onClick = {
                val list = series.toMutableList()
                val sum = cur + next
                cur = next
                next = sum

                list.add(cur)
                series = list
            }) {
                Text(text = "Button")
            }
        }
    }
}