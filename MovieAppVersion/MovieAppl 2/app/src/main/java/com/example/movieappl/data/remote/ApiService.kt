package com.example.movieappl.data.remote

import com.example.movieappl.data.remote.dto.MovieResponse
import com.example.movieappl.data.remote.dto.SearchResponse
import com.example.movieappl.data.remote.dto.SeriesResponse
import com.example.movieappl.model.Series
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    // MOVIES
    @GET("trending/movie/week")
    suspend fun getTrendingMovies(
        @Query("api_key") key: String,
        @Query("page") page: Int = 1
    ): MovieResponse

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") key: String,
        @Query("page") page: Int = 1
    ): MovieResponse

    @GET("movie/now_playing")
    suspend fun getNewMovies(
        @Query("api_key") key: String,
        @Query("page") page: Int = 1
    ): MovieResponse

    // SERIES
    @GET("trending/tv/week")
    suspend fun getTrendingSeries(
        @Query("api_key") key: String,
        @Query("page") page: Int = 1
    ): SeriesResponse

    @GET("tv/popular")
    suspend fun getPopularSeries(
        @Query("api_key") key: String,
        @Query("page") page: Int = 1
    ): SeriesResponse

    @GET("tv/on_the_air")
    suspend fun getNewSeries(
        @Query("api_key") key: String,
        @Query("page") page: Int = 1
    ): SeriesResponse


    @GET("search/multi")
    suspend fun searchMulti(
        @Query("api_key") key: String,
        @Query("query") query: String,
        @Query("page") page: Int = 1
    ): SearchResponse

}