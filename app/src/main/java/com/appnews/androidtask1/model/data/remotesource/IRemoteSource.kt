package com.appnews.androidtask1.model.data.remotesource

import com.appnews.androidtask1.model.pojo.Home
import retrofit2.Response

interface IRemoteSource {

    suspend fun getHomeData():Response<Home>

}