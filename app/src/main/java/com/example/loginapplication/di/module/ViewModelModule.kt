package com.example.loginapplication.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.domain.repository.ILoginRepo
import com.example.data.LoginLocalSource
import com.example.data.LoginRepoImp
import com.example.data.local.LoginDB
import com.example.data.local.sources.LoginLocalSourceImpl
import com.example.loginapplication.di.factory.ViewModelFactory
import com.example.loginapplication.ui.employee.EmployeeViewModel
import com.example.loginapplication.ui.login.LoginViewModel
import com.xpresspa.treatmobile.injection.scope.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton


@Module
abstract class ViewModelModule {


    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginVM(loginVM: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EmployeeViewModel::class)
    abstract fun bindEmployeeVM(loginVM: EmployeeViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract  fun provideLogRepoSource(db: LoginRepoImp): ILoginRepo

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract  fun provideLoginLocalSource(db: LoginLocalSourceImpl):LoginLocalSource
    }

