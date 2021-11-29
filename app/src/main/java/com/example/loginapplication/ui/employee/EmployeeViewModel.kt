package com.example.loginapplication.ui.employee

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.loginapplication.ui.Base.BaseViewModel
import com.example.loginapplication.utils.network.NetworkUtil
import javax.inject.Inject

class EmployeeViewModel @Inject constructor(
    private val networkUtil: NetworkUtil
) : BaseViewModel() {


    private var _viewState = MutableLiveData<EmployeeViewState>()
    val viewState: LiveData<EmployeeViewState> = _viewState



    init {
       // val characters = repository.getCharacters()

    }
}