package com.sushil.vmwithlambda

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController

@Composable
fun Screen1(
    navController: NavController,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val count by viewModel.counter.collectAsStateWithLifecycle()
    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = Color.Magenta.copy(alpha = 0.3f))
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "This is Screen 1")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Counter: $count")
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { viewModel.incrementCounter() }) {
                Text("Increment Counter")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { navController.navigate("screen2") }) {
                Text("Go to Page 2")
            }
        }
    }
}