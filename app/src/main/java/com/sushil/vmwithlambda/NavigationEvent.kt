package com.sushil.vmwithlambda

sealed class NavigationEvent {
    object OnBack : NavigationEvent()
    object OnCancel : NavigationEvent()
}