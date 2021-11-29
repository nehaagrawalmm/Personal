package com.example.loginapplication.ui.login

sealed class LoginViewState {
    object Loading : LoginViewState()
    object NavigateToEmplyeeList : LoginViewState()
    class Error(val message: String) : LoginViewState()
}