package com.definelab.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {

   @GET("/posts")
   fun getAllPosts() : Call<List<Posts>>
//    fun getAllPosts(@Query("latitude") userLatitude:String,
//                    @Query("longitude") userLongitude:String) : Call<List<Posts>>
//
}