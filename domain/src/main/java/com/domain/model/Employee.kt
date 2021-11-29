package com.domain.model

import android.os.Parcelable
import com.domain.mappers.DomainModel
import kotlinx.parcelize.Parcelize


@Parcelize
data class Employee(
    val email: String,
    val firstName: String,
    val lastName: String
) : DomainModel(), Parcelable

