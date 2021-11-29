package com.example.data.remote

import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

/**
 * Created by Saurabh Mishra on 15/09/20
 */
interface EmployeeApis {

  companion object {
    fun createRetrofitService(retrofit: Retrofit): EmployeeApis {
      return retrofit.create(EmployeeApis::class.java)
    }
  }

  @GET("employees/getempleoeelist")
  suspend fun getEmployees(): List<Employee>

}