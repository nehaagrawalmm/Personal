package com.example.domain

import com.example.data.LoginLocalSource
import com.example.data.local.entities.LoginEntity

class LoginUserUseCase(private val reporsitory: LoginLocalSource) {
    suspend fun getLoginUsers(): List<LoginEntity> {
        return reporsitory.getLoginUser()
    }

}