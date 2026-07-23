package com.example.movieappl.data.remote.dto

data class MovieDto(
    val id: Int,
    val title: String,
    val poster_path: String,
    val vote_average: Double,
    val overview: String,
    val release_date: String
){

}