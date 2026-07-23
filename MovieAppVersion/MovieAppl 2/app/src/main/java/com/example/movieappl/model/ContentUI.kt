package com.example.movieappl.model

data class ContentUI(
    val id:Int,
    val title: String,
    val rating: String,
    val type:String,
    val description:String = "",
    val imageUrl: String = "",
    val date:String = ""){

}