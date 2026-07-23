package com.definelab.assingment.data.remote

import com.definelab.assingment.utils.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.definelab.assingment.data.remote.ApiService


object RetrofitClient{
    val api: ApiService by lazy{
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}