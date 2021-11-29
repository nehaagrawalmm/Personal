package com.example.loginapplication.di.module

import android.content.Context
import androidx.room.Room
import com.example.data.local.LoginDB
import com.example.loginapplication.di.qualifiers.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    internal fun provideLoginDb(@ApplicationContext context: Context): LoginDB {
        return Room.databaseBuilder(context, LoginDB::class.java, LoginDB.DB_NAME)
            .build()
    }
}