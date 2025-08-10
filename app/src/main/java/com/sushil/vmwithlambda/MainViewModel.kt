package com.sushil.vmwithlambda

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    val onBack: () -> Unit,
    val onCancel: () -> Unit
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
    private val onBack: () -> Unit,
    private val onCancel: () -> Unit
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(onBack, onCancel) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}