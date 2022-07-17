package com.appnews.androidtask1.model.data.repository

import com.appnews.androidtask1.model.factories.NetworkResponse
import com.appnews.androidtask1.model.pojo.Home

interface IRepository {

    suspend fun getHomeData(): NetworkResponse<Home>
}