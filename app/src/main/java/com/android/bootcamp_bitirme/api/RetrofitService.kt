package com.android.bootcamp_bitirme.api

import com.android.bootcamp_bitirme.models.ItunesResult
import com.android.bootcamp_bitirme.models.MusicData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {
    @GET("search?&limit=20")
    suspend fun getAll(@Query("entity")entityName:String
               ,@Query("attribute")attributeName:String
               ,@Query("term")searchText:String
               ,@Query("offset") offsetLimit:String
    ): Response<ItunesResult>
}