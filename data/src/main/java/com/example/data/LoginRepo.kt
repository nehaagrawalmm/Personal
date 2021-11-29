package com.example.data

import com.example.data.local.entities.LoginEntity
 class LoginRepo constructor(
    private val localSource: LoginLocalSource,
) {
    suspend fun getLLoginLocalUser(): List<LoginEntity> {
        return localSource.getLoginUser()
    }

    suspend fun saveLoginUser(user: LoginEntity) {
        localSource.saveLoginUser(user)
    }

}

interface LoginLocalSource {
    suspend fun getLoginUser(): List<LoginEntity>
    suspend fun saveLoginUser(user:LoginEntity)

}

