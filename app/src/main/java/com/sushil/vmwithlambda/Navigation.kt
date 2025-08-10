package com.sushil.vmwithlambda

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Navigation() {
    val navController = rememberNavController()

    val onBack: () -> Unit = { navController.navigateUp() }
    val onCancel: () -> Unit = {
        navController.navigate("screen1") {
            popUpTo("screen1") { inclusive = true }
        }
    }

    val mainViewModel: MainViewModel = viewModel(
        factory = MainViewModelFactory(onBack, onCancel)
    )

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
