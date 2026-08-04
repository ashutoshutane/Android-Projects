package com.definelab.cofeeappusingcompose.model

data class OrderItems(
    val productId:String,
    val name:String,
    val imageUrl:String,
    val price:Double,
    val quantity:Int
) {
}