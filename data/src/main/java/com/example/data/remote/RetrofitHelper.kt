package com.mutualmobile.praxis.data.remote

import com.example.data.BuildConfig
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitHelper {


    fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
           // interceptors().addAll(interceptors)
            // Some requests take longer to process in the server
            // Which is bad, to be honest, but to deal with it for now,
            // we have increased timeout which by default is 10 seconds
            readTimeout(1, TimeUnit.MINUTES)
            connectTimeout(1, TimeUnit.MINUTES)
            writeTimeout(1, TimeUnit.MINUTES)
        }.build()
    }

    fun createRetrofitClient(okHttpClient: OkHttpClient, moshi: Moshi, baseUrl: String):
            Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
}