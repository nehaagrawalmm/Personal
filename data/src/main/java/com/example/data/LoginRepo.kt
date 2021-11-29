package com.example.data

import com.example.data.local.entities.LoginEntity
 class LoginRepo constructor(
    private val localSource: LoginLocalSource,
) {
    suspend fun getLLoginLocalUser(): List<LoginEntity> {
        return localSource.getLoginUsers()
    }

    suspend fun saveLoginUser(user: LoginEntity) {
        localSource.saveLoginUser(user)
    }

}

interface LoginLocalSource {
    suspend fun getLoginUsers(): List<LoginEntity>
    suspend fun getLoginUser(userName:String,password:String):LoginEntity?
    suspend fun saveLoginUser(user:LoginEntity)

}

