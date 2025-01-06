package com.example.assignment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
fun Screen3(navController: NavController) {
    var alphabet by rememberSaveable { mutableStateOf<List<String>>(listOf()) }
    var char1 = 'a'
    var char2 = 'a'
    var char3 = 'a'
    var char4 = 'b'
    var char5 = 'c'
    var char6 = 'd'

    LazyVerticalGrid(
        columns = GridCells.Adaptive(60.dp),
        verticalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(alphabet) {
            Text(
                text = it,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp),
                textAlign = TextAlign.Center
            )

        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = AbsoluteAlignment.Left
    ) {
        Row {
            Button(onClick = { navController.navigate("Screen2") }
            ) {
                Text(text = "2")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { navController.navigate("Screen3") }) {
                Text(text = "3")
            }
            Spacer(modifier = Modifier.width(110.dp))
            Button(onClick = {
                val list = alphabet.toMutableList()
                if (char1 <= 'z') {
                    list.add(char1.toString())
                    char1 = char1.inc()
                }
                else if (char2 <= 'z'){
                    list.add(char3.plus(char2.toString()))
                    char2 = char2.inc()
                }
                else if(char3 <= 'z'){
                    list.add(char4.plus(char3.toString()))
                    char3 = char3.inc()
                }
                else if (char4 <= 'z' ){
                    list.add(char5.plus(char4.toString()))
                    char4 = char4.inc()
                }else if(char5 <= 'z'){
                    list.add(char6.plus(char5.toString()))
                    char5 = char5.inc()
                }
                alphabet = list
            }) {
                Text(text = "Button")
            }
        }
    }
}
