package com.domain.usecase

import com.domain.repository.ILoginRepo
import javax.inject.Inject


class LoginUserUseCase @Inject constructor(private val loginRepo: ILoginRepo) {

   suspend fun loginUser(username: String, password: String, conPassword: String?): SafeResult<Boolean> {

           return when (val result = loginRepo.getLoggedInUser(username, password, conPassword)) {
               is SafeResult.Success -> SafeResult.Success(true)
               is SafeResult.NetworkError -> result
               is SafeResult.Failure -> result
           }


   }

}