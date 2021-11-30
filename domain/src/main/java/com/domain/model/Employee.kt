package com.domain.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

// This type of user is sent mainly by the user api


@JsonClass(generateAdapter = true)
@Parcelize
data class EmpResponse(
    @field:Json(name = "Employees")
    val data: List<Employee>
):Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Employee(
    @field:Json(name = "userId")
    val userId: Int = -1,
    @field:Json(name = "jobTitleName")
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

    @field:Json(name = "emailAddress")
    val emailAddress: String = "",
) : Parcelable



