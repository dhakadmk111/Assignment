package com.example.assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.assignment.ui.theme.AssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AssignmentTheme {
                MultiScreenApp()
            }
        }
    }
}

@Composable
fun MultiScreenApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = "Screen1"
    ) {
        composable("Screen1") { Screen1(navController) }
        composable("Screen2") { Screen2(navController) }
        composable("Screen3") { Screen3(navController) }
    }
}




