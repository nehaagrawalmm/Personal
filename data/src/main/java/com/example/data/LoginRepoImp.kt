package com.example.data

import com.domain.model.LoginUser
import com.domain.repository.ILoginRepo
import com.domain.usecase.SafeResult
import com.example.data.local.entities.LoginEntity
import com.example.data.remote.Employee
import javax.inject.Inject

class LoginRepoImp @Inject constructor(
    private val localSource: LoginLocalSource,
) : ILoginRepo {
    suspend fun getLLoginLocalUser(): List<LoginEntity> {
        return localSource.getLoginUsers()
    }

    suspend fun saveLoginUser(user: LoginEntity) {
        localSource.saveLoginUser(user)
    }



    override suspend fun getLoggedInUser(
        username: String,
        password: String,
        conPassword: String?
    ): SafeResult<Boolean> {
        if(conPassword!=null){
            if(conPassword==password && username!=null)
                localSource.saveLoginUser(LoginEntity(userName = username,email = username,password = password))
        }else{
            localSource.getLoginUser(username,password) ?: return SafeResult.Failure()
        }

        return SafeResult.Success(true)
    }

}

interface LoginLocalSource {
    suspend fun getLoginUsers(): List<LoginEntity>
    suspend fun getLoginUser(userName:String,password:String):LoginEntity?
    suspend fun saveLoginUser(user:LoginEntity)

}


interface LoginNetworkSource {
    suspend fun getEmployees(): SafeResult<Employee>

}

