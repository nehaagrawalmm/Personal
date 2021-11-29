package com.example.loginapplication.ui.employee

import android.app.Activity
import android.content.Intent
import com.example.loginapplication.R
import com.example.loginapplication.databinding.ActivityLoginBinding
import com.example.loginapplication.ui.Base.BaseActivity

class EmployeeActivity: BaseActivity<ActivityLoginBinding, EmployeeViewModel>() {

    companion object{
        fun launch(actvity:Activity){
            actvity.startActivity(Intent(actvity,EmployeeActivity::class.java))
        }
    }
    override fun getViewModelClass()= EmployeeViewModel::class.java


    override fun getLayoutId(): Int {
      return R.layout.activity_employee
    }
}