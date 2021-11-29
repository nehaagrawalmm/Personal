package com.example.data.remote

import android.os.Parcelable
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
    val firstName: String? = null,

    @Json(name = "lastName")
    val lastName: String? = null,

    @Json(name = "preferredFullName")
    val preferredFullName: String? = null,

    val employeeCode: String? = null,

    @Json(name = "preferredFullName")
    val phoneNumber: String? = null,
    val region: String? = null,

    @Json(name = "emailAddress")
    val emailAddress: String? = null,
) : Parcelable

