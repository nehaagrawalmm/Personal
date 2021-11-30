package com.example.data.remote


import com.domain.model.EmpResponse
import com.domain.model.Employee
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query


interface EmployeeApis {

  companion object {
    fun createRetrofitService(retrofit: Retrofit): EmployeeApis {
      return retrofit.create(EmployeeApis::class.java)
    }
  }



  @GET("/employees/getempleoeelist")
  suspend fun getEmployees(): EmpResponse

}