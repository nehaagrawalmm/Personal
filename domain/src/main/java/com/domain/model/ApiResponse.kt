package com.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponse<T>(
  val data: T? = null,
  val message: String = ""
)