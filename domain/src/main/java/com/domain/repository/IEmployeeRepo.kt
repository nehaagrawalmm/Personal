package com.domain.repository


import com.domain.model.EmpResponse
import com.domain.usecase.SafeResult

interface IEmployeeRepo {
    suspend fun getEmployeeList(): SafeResult<EmpResponse>

}