package com.example.loginapplication.ui.employee

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import com.domain.model.Employee
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

    private var employeeAdapter: EmployeeAdapter? = null

    override fun getViewModelClass()= EmployeeViewModel::class.java


    override fun getLayoutId(): Int {
      return R.layout.activity_employee
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupObservers()
        setRecycler()
    }

    private fun setRecycler() {
        employeeAdapter = EmployeeAdapter()
        binding.listEmp.apply {
            adapter = employeeAdapter
            addItemDecoration(DividerItemDecoration(this.context, LinearLayout.HORIZONTAL))
        }
    }

    private fun setupObservers() {
        viewModel.viewState
            .observe(this) { viewState ->
                when (viewState) {
                    is EmployeeViewState.Loading -> showLoader(viewState.show)
                    is EmployeeViewState.Error -> showSnackbarMessage(viewState.message)
                    is EmployeeViewState.Employees -> {
                       // setTeammateCount(viewState.teammates.size)
                        loadData(viewState.employees)
                    }
                }
            }
    }

    private fun loadData(teammates: List<Employee>) {
        employeeAdapter?.setItems(teammates)
    }



    private fun showLoader(showLoader: Boolean) {
        binding.loading.isVisible = showLoader
    }

}