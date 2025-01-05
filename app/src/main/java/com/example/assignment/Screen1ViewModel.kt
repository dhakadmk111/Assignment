package com.example.assignment

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.update

class Screen1ViewModel: ViewModel(){
    private var buttonText = MutableStateFlow<List<String>>(emptyList())
    var value = buttonText.asStateFlow()


    fun event(){
        var value = 1100
        val list = mutableListOf(buttonText.toString())
         value -= 100
        val a = if (value % 200 == 0) {
            value.toString()
        } else {
            "-".plus(value.toString())
        }
        list.add(a)
        buttonText.update{buttonText.value }
    }
}
