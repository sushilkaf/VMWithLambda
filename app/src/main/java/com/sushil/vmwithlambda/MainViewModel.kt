package com.sushil.vmwithlambda

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    val onBack: (NavController) -> Unit,
    val onCancel: (NavController) -> Unit
) : ViewModel() {

    private val _counter = MutableStateFlow(0)
    val counter = _counter.asStateFlow()

    fun incrementCounter() {
        viewModelScope.launch {
            _counter.value++
        }
    }
}

class MainViewModelFactory(
    private val onBack: (NavController) -> Unit,
    private val onCancel: (NavController) -> Unit
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(onBack, onCancel) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}