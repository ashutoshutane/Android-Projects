package com.definelab.cofeeappusingcompose.model

data class CartItems(
    val productId:String,
    val name:String,
    val imageUrl:String,
    val price: Double,
    val quantity:Int,
    val totalPrice: Double

) {
}