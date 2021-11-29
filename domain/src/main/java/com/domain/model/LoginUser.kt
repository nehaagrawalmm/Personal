package com.domain.model

import android.os.Parcelable
import com.domain.mappers.DomainModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginUser(
    val email: String,
    val password: String
) : DomainModel(), Parcelable

