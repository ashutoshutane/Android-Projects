package com.example.movieappl.data.local


class SavedItem(
    val id: Int,
    val title: String,
    val imageUrl : String = "",
    val rating: String,
    val type: String,
    val description:String
) {
}