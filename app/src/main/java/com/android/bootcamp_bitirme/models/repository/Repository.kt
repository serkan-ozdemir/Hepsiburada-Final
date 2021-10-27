package com.android.bootcamp_bitirme.models.repository

import com.android.bootcamp_bitirme.models.ItunesResult
import com.android.bootcamp_bitirme.api.Retrofit
import com.android.bootcamp_bitirme.models.MusicData
import retrofit2.Response

class Repository {

    suspend fun getAll(entityName:String, attributeName:String,searchText:String,offsetLimit:String):Response<ItunesResult>{
        return Retrofit.service.getAll(entityName, attributeName, searchText, offsetLimit)
    }
}