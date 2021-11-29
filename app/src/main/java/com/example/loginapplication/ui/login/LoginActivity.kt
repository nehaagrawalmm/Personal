package com.example.loginapplication.ui.login

import android.app.Activity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import com.example.loginapplication.databinding.ActivityLoginBinding

import com.example.loginapplication.R
import com.example.loginapplication.ui.Base.BaseActivity

class LoginActivity :BaseActivity<ActivityLoginBinding, LoginViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setObservers()
    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome)
        val displayName = model.displayName
        Toast.makeText(
            applicationContext,
            "$welcome $displayName",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }

    private fun setObservers(){
       /* val username = binding.username
        val password = binding.password
        val login = binding.login
        val loading = binding.loading*/


        viewModel.loginFormState.observe(this@LoginActivity, Observer {
            val loginState = it ?: return@Observer

            // disable login button unless both username / password is valid
            _binding?.let {_bind->
                _bind.login.isEnabled = loginState.isDataValid

                if (loginState.usernameError != null) {
                    _bind.username.error = getString(loginState.usernameError)
                }
                if (loginState.passwordError != null) {
                    _bind.password.error = getString(loginState.passwordError)
                }
            }

        })

        viewModel.loginResult.observe(this@LoginActivity, Observer {
            val loginResult = it ?: return@Observer

            _binding?.loading!!.visibility = View.GONE
            if (loginResult.error != null) {
                showLoginFailed(loginResult.error)
            }
            if (loginResult.success != null) {
                updateUiWithUser(loginResult.success)
            }
            setResult(Activity.RESULT_OK)

            //Complete and destroy login activity once successful
            // finish()
        })

        _binding?.let {_bind->
            _bind.username.afterTextChanged {
                viewModel.loginDataChanged(
                    _bind.username.text.toString(),
                    _bind.password.text.toString()
                )
            }
        }

        _binding?.let {_bind->
            _bind.password.apply {
            afterTextChanged {
                viewModel.loginDataChanged(
                    _bind.username.text.toString(),
                    _bind.password.text.toString()
                )
            }

            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        viewModel.login(
                            _bind.username.text.toString(),
                            _bind.password.text.toString()
                        )
                }
                false
            }

                _bind.login.setOnClickListener {
                    _bind.loading.visibility = View.VISIBLE
                viewModel.login(_bind.username.text.toString(), _bind.password.text.toString())
            }
        }
        }
    }

    override fun getLayoutId(): Int {
       return R.layout.activity_login
    }

    override fun getViewModelClass() = LoginViewModel::class.java



}

/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}