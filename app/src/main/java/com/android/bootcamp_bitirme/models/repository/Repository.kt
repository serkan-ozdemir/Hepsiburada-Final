package com.android.bootcamp_bitirme.models.repository

import com.android.bootcamp_bitirme.models.ItunesResult
import com.android.bootcamp_bitirme.api.Retrofit
import retrofit2.Response

class Repository {
    suspend fun getAll(mediaName:String,searchText:String,offsetLimit:String):Response<ItunesResult>{
        return Retrofit.service.getAll(mediaName, searchText, offsetLimit)
    }
}