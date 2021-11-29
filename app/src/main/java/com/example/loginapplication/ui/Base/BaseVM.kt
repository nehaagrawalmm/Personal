package com.example.loginapplication.ui.Base

import androidx.lifecycle.ViewModel

abstract class BaseVM : ViewModel() {
  override fun onCleared() {
    super.onCleared()
  }

  // TODO - Try to refactor the view models to remove the extra backing field required with each view model
  // Do not remove the commented code
  /*protected fun <T> LiveData<T>.postValue(value: T?) {
    if(this is MutableLiveData<T>) postValue(value)
    else error("Not a mutable live data.")
  }

  protected fun <T> LiveData<T>.setValue(value: T?) {
    if(this is MutableLiveData<T>) setValue(value)
    else error("Not a mutable live data.")
  }*/
}