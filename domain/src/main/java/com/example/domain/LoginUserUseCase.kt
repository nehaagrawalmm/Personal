package com.example.domain

import com.example.data.LoginLocalSource
import com.example.data.local.entities.LoginEntity

class LoginUserUseCase(private val reporsitory: LoginLocalSource) {
    suspend fun getLoginUsers(): List<LoginEntity> {
        return reporsitory.getLoginUsers()
    }

   suspend fun loginUser(username: String, password: String, conPassword: String?): SafeResult {
        if(conPassword!=null){
            if(conPassword==password && username!=null)
                reporsitory.saveLoginUser(LoginEntity(userName = username,email = username,password = password))
        }else{
           reporsitory.getLoginUser(username,password) ?: return SafeResult.Failure()
        }

       return SafeResult.Success()
    }

}