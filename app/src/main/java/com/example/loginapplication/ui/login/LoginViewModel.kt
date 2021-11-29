package com.example.loginapplication.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.util.Patterns
import androidx.lifecycle.viewModelScope
import com.domain.model.LoginUser
import com.domain.usecase.LoginUserUseCase
import com.domain.usecase.SafeResult
import com.example.loginapplication.R
import com.example.loginapplication.ui.Base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginUserUseCase: LoginUserUseCase
) : BaseViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<SafeResult<Boolean>>()
    val loginResult: LiveData<SafeResult<Boolean>> = _loginResult

     fun login(username: String, password: String,conPassword:String?=null) {
         viewModelScope.launch {
             _loginResult.value= when (val result = loginUserUseCase.loginUser(username,password,conPassword)) {
                 is SafeResult.Success -> SafeResult.Success(result.data)
                 is SafeResult.NetworkError -> result
                 is SafeResult.Failure -> result
             }

         }


    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(
                usernameError = R.string.invalid_username
            )
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}