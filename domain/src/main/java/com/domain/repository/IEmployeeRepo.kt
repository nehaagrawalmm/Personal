package com.domain.repository

import com.domain.model.Employee
import com.domain.usecase.SafeResult

interface IEmployeeRepo {
    suspend fun getEmployeeList(): SafeResult<List<Employee>>

}