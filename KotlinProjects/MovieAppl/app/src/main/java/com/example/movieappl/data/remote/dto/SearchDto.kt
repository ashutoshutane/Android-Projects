package com.example.movieappl.data.remote.dto

import com.google.gson.annotations.SerializedName

class SearchDto(
    val id :Int,
    @SerializedName("title")
    val movie_name :String?,
    @SerializedName("name")
    val series_name : String?,
    val poster_path : String?,
    val vote_average : Double,
    val overview : String,
    val media_type :String

) {
}
