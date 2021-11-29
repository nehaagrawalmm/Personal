package com.example.loginapplication.di.module


import com.example.loginapplication.di.qualifiers.ActivityScope
import com.example.loginapplication.ui.login.LoginActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * To create dependencies for a specific activity,
 * don't extend the required activity module with #ActivityModule,
 * instead create a plain module and include #BaseActivityModule in the annotation.
 */
@Module
abstract class ActivityBindingModule {

  @ActivityScope
  @ContributesAndroidInjector
  abstract fun bindLoginActivity(): LoginActivity


}