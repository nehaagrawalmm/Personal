package com.example.data.remote

import android.os.Parcelable
import com.example.data.local.dao.User
import com.example.data.local.entities.LoginEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

// This type of user is sent mainly by the user api
@JsonClass(generateAdapter = true)
@Parcelize
data class Employee(
    @Json(name = "userId")
    val userId: Int = -1,
    @Json(name = "jobTitleName")
    val jobTitleName: String? = null,

    @Json(name = "firstName")
    val firstName: String= "",

    @Json(name = "lastName")
    val lastName: String = "",

    @Json(name = "preferredFullName")
    val preferredFullName: String? = null,

    val employeeCode: String? = null,

    @Json(name = "preferredFullName")
    val phoneNumber: String? = null,
    val region: String? = null,

    @Json(name = "emailAddress")
    val emailAddress: String = "",
) : Parcelable


fun Employee.toDomain(): com.domain.model.Employee {
    return com.domain.model.Employee(
        email=this.emailAddress,
        firstName=this.firstName,
         lastName= this.lastName)}

