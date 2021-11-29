package com.example.loginapplication.ui.employee

import com.domain.model.Employee
import com.example.data.local.dao.User

sealed class EmployeeViewState {
class Loading(val show: Boolean) : EmployeeViewState()
    class Error(val message: String) : EmployeeViewState()
    class Employees(val employees: List<Employee>) : EmployeeViewState()
}