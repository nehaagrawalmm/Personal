package com.example.loginapplication.di.module

import com.example.data.LoginLocalSource
import com.example.data.LoginRepo
import com.example.data.local.LoginDB
import com.example.data.local.sources.LoginLocalSourceImpl
import com.example.loginapplication.data.LoginRepository
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
class LoginModule {

    @Provides
    @Singleton
    internal fun provideLoginLocalSource(db: LoginDB): LoginLocalSource {
        return LoginLocalSourceImpl(db, Dispatchers.IO)
    }

    @Provides
    @Singleton
    internal fun provideUserRepo( userLocalSource: LoginLocalSource): LoginRepo {
        return LoginRepo( userLocalSource)
    }


}