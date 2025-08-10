package com.sushil.vmwithlambda

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Navigation() {
    val navController = rememberNavController()

    val mainViewModel: MainViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "screen1"
    ) {
        composable("screen1") {
            Screen1(navController, mainViewModel)
        }
        composable("screen2") {
            Screen2(navController, mainViewModel)
        }
        composable("screen3") {
            Screen3(navController, mainViewModel)
        }
    }
}
