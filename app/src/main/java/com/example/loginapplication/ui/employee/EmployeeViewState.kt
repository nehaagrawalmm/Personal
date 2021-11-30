package com.example.loginapplication.ui.employee

import com.domain.model.Employee

sealed class EmployeeViewState {
class Loading(val show: Boolean) : EmployeeViewState()
    class Error(val message: String) : EmployeeViewState()
    class Employees(val employees: List<Employee>) : EmployeeViewState()
}