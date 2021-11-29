package com.example.data.local.sources

import com.example.data.LoginLocalSource
import com.example.data.local.LoginDB
import com.example.data.local.entities.LoginEntity
import com.example.data.local.entities.toEntity
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.withContext


class LoginLocalSourceImpl(
  private val db: LoginDB,
  private val executionContext: CoroutineContext
) : LoginLocalSource {





  override suspend fun getLoginUsers(): List<LoginEntity> {
    return withContext(executionContext) {
      db.loginDao().getLoginUsers()
    }
  }

  override suspend fun getLoginUser(
    userName: String,
    password: String
  ): LoginEntity? {
   return withContext(executionContext) {
      db.loginDao().getLoginUser(userName,password)
    }  }


  override suspend fun saveLoginUser(user: LoginEntity) {
    withContext(executionContext) {
      db.loginDao().insertLoginUser(user.toEntity())
    }
  }


}
