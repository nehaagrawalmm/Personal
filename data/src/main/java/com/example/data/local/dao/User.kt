package com.example.data.local.dao

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize


// This type of user is sent mainly by the user api
@JsonClass(generateAdapter = true)
@Parcelize
data class User(
    val uid: Int = -1,
    val name: String? = null,
    val email: String? = null,
    val password: String? = null,
) : Parcelable
