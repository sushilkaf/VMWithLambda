package com.sushil.vmwithlambda

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.collectLatest


@Composable
fun Navigation() {
    val navController = rememberNavController()

    val mainViewModel: MainViewModel = viewModel()

    LaunchedEffect(Unit) {
        mainViewModel.navigationEvents.collectLatest { event ->
            when (event) {
                is NavigationEvent.OnBack -> {
                    navController.navigateUp()
                }
                is NavigationEvent.OnCancel -> {
                    navController.navigate(
                        "Screen1"
                    ) {
                        popUpTo("Screen1") {
                            inclusive = true
                        }
                    }
                }
            }
        }
    }

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
