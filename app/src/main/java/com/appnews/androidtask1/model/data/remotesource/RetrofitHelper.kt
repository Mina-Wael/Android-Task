package com.appnews.androidtask1.model.data.remotesource

import com.appnews.androidtask1.model.pojo.Home
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://backend.forhomi.com/api/"


private val retrofit = Retrofit.Builder().apply {
    baseUrl(BASE_URL)
    addConverterFactory(GsonConverterFactory.create())
}.build()

object RetrofitHelper : IRemoteSource {
    private val retrofitService by lazy { retrofit.create(RetrofitService::class.java) }
    override suspend fun getHomeData(): Response<Home> {
       return retrofitService.getHomeData()
    }


}