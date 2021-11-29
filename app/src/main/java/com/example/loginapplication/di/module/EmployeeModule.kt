package com.example.loginapplication.di.module

import com.domain.repository.IEmployeeRepo
import com.domain.repository.ILoginRepo
import com.domain.usecase.EmployeeUseCae
import com.example.data.AppConstants
import com.example.data.LoginLocalSource
import com.example.data.LoginRepoImp
import com.example.data.local.LoginDB
import com.example.data.remote.EmployeeApis
import com.example.data.remote.sources.EmployeeRepoImp
import com.mutualmobile.praxis.data.remote.RetrofitHelper
import com.mutualmobile.praxis.data.sources.EmpRemoteSource
import com.mutualmobile.praxis.data.sources.IEmplRemoteSource
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class EmployeeModule {

    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        return RetrofitHelper.createOkHttpClient()
    }


    @Provides @Singleton fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .build()
    }


    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
    moshi: Moshi
    ): Retrofit {
        return RetrofitHelper.createRetrofitClient(okHttpClient, moshi,AppConstants.BASE_URL)
    }


    @Provides
    internal fun provideEmpApiService(retrofit: Retrofit): EmployeeApis {
        return EmployeeApis.createRetrofitService(retrofit)
    }

    @Provides
    @Singleton
    internal fun provideLoginUserUseCase( userLocalSource: IEmployeeRepo): EmployeeUseCae {
        return EmployeeUseCae(userLocalSource)
    }

    @Provides
    internal  fun provideLoginLocalRepo(db: EmployeeApis): IEmployeeRepo {
        return EmployeeRepoImp(db,Dispatchers.IO)
    }

    @Provides
    internal  fun provideLoginLocalSource(db: EmployeeApis): IEmplRemoteSource {
        return EmpRemoteSource(db, Dispatchers.IO)
    }




}