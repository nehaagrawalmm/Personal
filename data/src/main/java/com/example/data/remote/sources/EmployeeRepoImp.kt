package com.example.data.remote.sources

import com.domain.model.Employee
import com.domain.repository.IEmployeeRepo
import com.domain.usecase.SafeResult
import com.example.data.remote.EmployeeApis
import com.example.data.remote.toDomain
import com.mutualmobile.praxis.data.remote.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class EmployeeRepoImp(private val employeeApis: EmployeeApis,
                      private val dispatcher: CoroutineDispatcher = Dispatchers.IO):IEmployeeRepo

{
    override suspend fun getEmployeeList(): SafeResult<List<Employee>> {
        return safeApiCall(dispatcher) {
            employeeApis.getEmployees().map {  it.toDomain() }.toMutableList()
        }
    }
}