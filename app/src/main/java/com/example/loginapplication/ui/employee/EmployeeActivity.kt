package com.example.loginapplication.ui.employee

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.loginapplication.R
import com.example.loginapplication.databinding.ActivityEmployeeBinding
import com.example.loginapplication.databinding.ActivityLoginBinding
import com.example.loginapplication.ui.Base.BaseActivity

class EmployeeActivity: BaseActivity<ActivityEmployeeBinding, EmployeeViewModel>() {

    companion object{
        fun launch(actvity:Activity){
            actvity.startActivity(Intent(actvity,EmployeeActivity::class.java))
        }
    }
    override fun getViewModelClass()= EmployeeViewModel::class.java


    override fun getLayoutId(): Int {
      return R.layout.activity_employee
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupObservers()
    }


    private fun setupObservers() {
        viewModel.viewState
            .observe(this) { viewState ->
                when (viewState) {
                    is EmployeeViewState.Loading -> showLoader(viewState.show)
                    is EmployeeViewState.Error -> showSnackbarMessage(viewState.message)
                    is EmployeeViewState.TeamMember -> {
                       // setTeammateCount(viewState.teammates.size)
                        //loadData(viewState.teammates)
                    }
                }
            }
    }


    private fun showLoader(showLoader: Boolean) {
        binding.loading.isVisible = showLoader
    }

}