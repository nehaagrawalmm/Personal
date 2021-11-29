package com.domain.repository

import com.domain.usecase.SafeResult

interface ILoginRepo {
    suspend fun getLoggedInUser(username: String, password: String, conPassword: String?): SafeResult<Boolean>
}