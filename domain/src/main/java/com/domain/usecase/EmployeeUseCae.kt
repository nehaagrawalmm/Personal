package com.domain.usecase

import com.domain.model.Employee
import com.domain.repository.IEmployeeRepo
import javax.inject.Inject

class EmployeeUseCae @Inject constructor(private val empRepo: IEmployeeRepo) {

    suspend fun getEmployeeList(): SafeResult<List<Employee>> {
        return when (val result = empRepo.getEmployeeList()) {
            is SafeResult.Success -> SafeResult.Success(result.data)
            is SafeResult.NetworkError -> result
            is SafeResult.Failure -> result
        }


    }
}