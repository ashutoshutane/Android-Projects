package com.example.movieappl.data.remote.dto

import com.example.movieappl.model.ContentUI
import com.example.movieappl.utils.Constants

fun MovieDto.toUI(): ContentUI {
    return ContentUI(
        id = id,
        title = title,
        imageUrl = "https://image.tmdb.org/t/p/w500$poster_path",
        rating = vote_average.toString(),
        type = "movie",
        description = overview,
        date = release_date
    )
}

fun SeriesDto.toUI(): ContentUI {
    return ContentUI(
        id = id,
        title = name, // 🔥 IMPORTANT
        imageUrl = "https://image.tmdb.org/t/p/w500$poster_path",
        rating = vote_average.toString(),
        type = "series",
        description = overview,
        date = first_air_date // 🔥 IMPORTANT
    )
}

fun SearchDto.toUI(): ContentUI{
    return ContentUI(
        id = id,
        title = movie_name?:series_name?:"No title",
        imageUrl = poster_path?.let { "https://image.tmdb.org/t/p/w500$it" } ?: "",
        rating = vote_average.toString(),
        type = if (media_type == "tv") "series" else "movie",
        description = overview,
        date = ""
    )
}
