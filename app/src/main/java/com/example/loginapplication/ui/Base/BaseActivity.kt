package com.example.loginapplication.ui.Base

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.example.loginapplication.utils.network.NetworkUtil
import com.example.loginapplication.utils.validations.NetworkValidator
import com.example.loginapplication.utils.validations.ShowMessage
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import com.example.loginapplication.BR
import javax.inject.Inject

abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel> : DaggerAppCompatActivity(){

    private var snackBar: Snackbar? = null


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var networkUtil: NetworkUtil


    protected lateinit var viewModel: VM
    protected  var _binding: B?=null


    val binding: B get() = _binding!!

    abstract fun getViewModelClass(): Class<VM>
    abstract fun getLayoutId(): Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindContentView(getLayoutId())
    }



    // Bind the view and bind the viewModel to layout
    private fun bindContentView(layoutId: Int) {
        _binding = DataBindingUtil.setContentView(this, layoutId)
        viewModel = ViewModelProvider(this, viewModelFactory).get(getViewModelClass())
        _binding?.setVariable(BR.viewModel, viewModel)
    }



    fun isConnectedToInternet(feedbackNeeded: Boolean = true): Boolean {
        val view: View = findViewById(android.R.id.content)
        val showFeedback = view != null && feedbackNeeded
        return NetworkValidator.checkNetworkConnection(view, this, networkUtil, showFeedback,object :ShowMessage{
            override fun showMessage(message: String) {
                showSnackbarMessage(message)
            }

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    protected fun showSnackbarMessage(
        message: String?,
        duration: Int = Snackbar.LENGTH_SHORT
    ) {
        snackBar = snackBar?.let {
            message?.let { it1 -> it.setText(it1) }
            if (!it.isShown) {
                it.show()
            }
            it
        } ?: run {
            message?.let {
                snackBar = Snackbar.make(binding.root, it, duration)
                snackBar?.show()
                snackBar
            }
        }
    }






}