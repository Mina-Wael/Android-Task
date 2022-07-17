package com.appnews.androidtask1.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.appnews.androidtask1.model.data.repository.IRepository

class HomeViewModelFactory(private val repository: IRepository): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }
}