package com.example.movieappl.data.remote.dto

data class SeriesDto(
    val id: Int,
    val name: String,
    val poster_path: String,
    val vote_average: Double,
    val overview: String,
    val first_air_date: String
) {

}