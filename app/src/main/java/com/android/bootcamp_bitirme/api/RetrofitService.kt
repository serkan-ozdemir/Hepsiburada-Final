package com.android.bootcamp_bitirme.api

import com.android.bootcamp_bitirme.models.ItunesResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("search?&limit=20")
    suspend fun getAll(@Query("media")mediaName:String
               ,@Query("term")searchText:String
               ,@Query("offset") offsetLimit:String
    ): Response<ItunesResult>
}