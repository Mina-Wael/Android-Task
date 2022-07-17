package com.appnews.androidtask1.ui.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appnews.androidtask1.model.data.repository.IRepository
import com.appnews.androidtask1.model.factories.NetworkResponse
import com.appnews.androidtask1.model.factories.ResultState
import com.appnews.androidtask1.model.pojo.Home
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeViewModel(private val repo: IRepository) : ViewModel() {

    private val _homeLiveData = MutableLiveData<ResultState<Home>>()
    val homeLiveData: LiveData<ResultState<Home>> = _homeLiveData

    fun getHomeData() {
        _homeLiveData.value = ResultState.Loading
        viewModelScope.launch {
            val result = async { repo.getHomeData() }
            sendHomeData(result.await())
        }
    }

    private fun sendHomeData(networkResponse: NetworkResponse<Home>) {
        when (networkResponse) {
            is NetworkResponse.SuccessResponse -> _homeLiveData.value =
                ResultState.Success(networkResponse.data)
            is NetworkResponse.FailureResponse -> _homeLiveData.value =
                ResultState.Error(networkResponse.errorString)
        }
    }
}