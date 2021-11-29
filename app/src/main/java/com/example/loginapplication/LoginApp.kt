package com.example.loginapplication

import com.example.loginapplication.di.AppComponent
import com.example.loginapplication.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject


 class LoginApp : DaggerApplication() {

    override fun applicationInjector():
            AndroidInjector<LoginApp> {
        return DaggerAppComponent.factory().create(this)
    }


}