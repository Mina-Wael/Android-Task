package com.appnews.androidtask1.model.data.remotesource

import com.appnews.androidtask1.model.pojo.Home
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET("home")
    suspend fun getHomeData(): Response<Home>

}