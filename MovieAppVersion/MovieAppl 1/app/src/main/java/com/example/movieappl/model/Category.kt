package com.example.movieappl.model

import com.example.movieappl.data.local.SavedItem


data class Category(
    val title: String,
    val list: List<SavedItem>
)