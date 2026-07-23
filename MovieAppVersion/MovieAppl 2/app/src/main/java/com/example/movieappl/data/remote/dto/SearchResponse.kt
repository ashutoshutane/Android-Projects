package com.example.movieappl.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    val page: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    val results: List<SearchDto>
) {
}