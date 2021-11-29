package com.example.loginapplication.di

import android.content.Context
import com.example.loginapplication.LoginApp
import com.example.loginapplication.di.module.ActivityBindingModule
import com.example.loginapplication.di.module.DatabaseModule
import com.example.loginapplication.di.module.LoginModule
import com.example.loginapplication.di.module.ViewModelModule
import com.example.loginapplication.ui.login.LoginActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    ViewModelModule::class,
    DatabaseModule::class,
    ActivityBindingModule::class,
    LoginModule::class,
    AndroidSupportInjectionModule::class
    ])
interface AppComponent: AndroidInjector<LoginApp> {
    @Component.Factory
    interface Factory: AndroidInjector.Factory<LoginApp>
}




