package com.example.loginapplication.di.module

import com.domain.repository.ILoginRepo
import com.example.data.LoginLocalSource
import com.example.data.local.LoginDB
import com.example.data.local.sources.LoginLocalSourceImpl
import com.domain.usecase.LoginUserUseCase
import com.example.data.LoginRepoImp
import com.example.loginapplication.ui.login.LoginViewModel
import com.xpresspa.treatmobile.injection.scope.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
class LoginModule {

    @Provides
    @Singleton
    internal fun provideLoginUserUseCase( userLocalSource: ILoginRepo): LoginUserUseCase {
        return LoginUserUseCase(userLocalSource)
    }

    @Provides
    internal  fun provideLoginLocalRepo(db: LoginLocalSource): ILoginRepo{
        return LoginRepoImp(db)
    }

    @Provides
    internal  fun provideLoginLocalSource(db: LoginDB): LoginLocalSource{
        return LoginLocalSourceImpl(db, Dispatchers.IO)
    }




}