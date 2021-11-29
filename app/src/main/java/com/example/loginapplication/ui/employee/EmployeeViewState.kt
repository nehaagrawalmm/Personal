package com.example.loginapplication.ui.employee

import com.example.data.local.dao.User

sealed class EmployeeViewState {
class Loading(val show: Boolean) : EmployeeViewState()
    class Error(val message: String) : EmployeeViewState()
    class TeamMember(val teammates: List<User>) : EmployeeViewState()
}