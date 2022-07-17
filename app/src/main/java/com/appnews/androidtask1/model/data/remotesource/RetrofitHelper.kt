package com.appnews.androidtask1.model.data.remotesource

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://backend.forhomi.com/api/"


private val retrofit = Retrofit.Builder().apply {
    baseUrl(BASE_URL)
    addConverterFactory(GsonConverterFactory.create())
}.build()

object RetrofitHelper : RemoteSource {
    private val retrofitService by lazy { retrofit.create(RetrofitService::class.java) }


}