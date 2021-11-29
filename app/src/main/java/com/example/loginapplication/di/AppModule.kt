package com.example.loginapplication.di

import android.accounts.AccountManager
import android.app.NotificationManager
import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.data.local.LoginDB
import com.example.loginapplication.LoginApp
import com.example.loginapplication.di.factory.ViewModelFactory
import com.example.loginapplication.di.qualifiers.ApplicationContext
import com.example.loginapplication.ui.login.LoginViewModel
import com.example.loginapplication.utils.NetworkUtilImpl
import com.example.loginapplication.utils.network.NetworkUtil
import com.xpresspa.treatmobile.injection.scope.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.security.KeyStore
import javax.inject.Provider
import javax.inject.Singleton

@Module
class AppModule {
  @Singleton
  @Provides
  @ApplicationContext
  fun provideAppContext(app: LoginApp): Context = app.applicationContext

  @Provides
  @Singleton
  fun provideConnectivityManager(@ApplicationContext context: Context): ConnectivityManager {
    return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
  }

  @Provides
  @Singleton
  fun provideNetworkUtils(
    connectivityManager: ConnectivityManager
  ): NetworkUtil {
    return NetworkUtilImpl(connectivityManager)
  }







}