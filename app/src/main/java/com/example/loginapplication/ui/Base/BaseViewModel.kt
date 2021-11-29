package com.example.loginapplication.ui.Base


import android.content.Context
import android.text.format.DateUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import androidx.databinding.ObservableBoolean;


abstract class BaseViewModel : ViewModel() {

    private val mIsLoading: ObservableBoolean = ObservableBoolean()

    open fun getIsLoading(): ObservableBoolean? {
        return mIsLoading
    }

    open fun setIsLoading(isLoading: Boolean) {
        mIsLoading.set(isLoading)
    }



    public override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }







}