package com.definelab.assingment.data.remote

import com.definelab.assingment.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService{
    @GET("v2/venues/search")
    suspend fun  getVenues(
        @Query("ll") i:String,
        @Query("oauth_token") token:String,
        @Query("v") version:String
    ): Response<ApiResponse>

}