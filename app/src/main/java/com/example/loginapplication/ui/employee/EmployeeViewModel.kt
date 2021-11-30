package com.example.loginapplication.ui.employee

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.domain.usecase.EmployeeUseCae
import com.domain.usecase.LoginUserUseCase
import com.domain.usecase.getSuccessOrNull
import com.example.loginapplication.ui.Base.BaseViewModel
import com.example.loginapplication.utils.network.NetworkUtil
import kotlinx.coroutines.launch
import javax.inject.Inject

class EmployeeViewModel @Inject constructor(
    private val employeeUseCase: EmployeeUseCae

) : BaseViewModel() {


    private var _viewState = MutableLiveData<EmployeeViewState>()
    val viewState: LiveData<EmployeeViewState> = _viewState



    init {
        viewModelScope.launch {
            val result=employeeUseCase.getEmployeeList().getSuccessOrNull()
            Log.d("neha ",result.toString())
            if(result!=null){
                _viewState.value= EmployeeViewState.Employees(result)
            }
            else{
                _viewState.value=EmployeeViewState.Error("Nothing Found")
            }

        }

    }
}