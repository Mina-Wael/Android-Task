package com.appnews.androidtask1.model.data.repository

import android.util.Log
import com.appnews.androidtask1.model.data.remotesource.IRemoteSource
import com.appnews.androidtask1.model.data.remotesource.RetrofitHelper
import com.appnews.androidtask1.model.factories.NetworkResponse
import com.appnews.androidtask1.model.pojo.Data
import com.appnews.androidtask1.model.pojo.Home
import kotlin.math.log

private const val BAD_CONNECTION = "Bad Connection"
private val emptyObject by lazy {
    Home(
        Data(
            emptyList(), emptyList(), emptyList(), emptyList(),
            emptyList()
        ), "", false
    )
}


class Repository(private val remoteSource: IRemoteSource = RetrofitHelper) : IRepository {

    override suspend fun getHomeData(): NetworkResponse<Home> {
        return try {
            val result = remoteSource.getHomeData()
            Log.i("TAG", "getHomeData: "+result.isSuccessful)
            if (result.isSuccessful)
                NetworkResponse.SuccessResponse(result.body() ?: emptyObject)
            else
                NetworkResponse.FailureResponse(result.errorBody()?.string().toString())

        } catch (e: Exception) {
            NetworkResponse.FailureResponse(BAD_CONNECTION)
        }
    }
}