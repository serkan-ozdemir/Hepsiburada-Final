package com.android.bootcamp_bitirme.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    private const val BASE_URL = "https://itunes.apple.com/"

    private val retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    val service: RetrofitService = retrofit.create(RetrofitService::class.java)
}