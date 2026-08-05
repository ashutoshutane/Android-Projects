package com.definelab.cofeeappusingcompose.data.repository

import com.definelab.cofeeappusingcompose.model.Product
import com.google.firebase.firestore.FirebaseFirestore


class FavoriteRepository{

    private val firestore = FirebaseFirestore.getInstance()
    private val favoriteCollection = firestore.collection("favorites")

    fun addFavorite(
        uid: String,
        product: Product,
        onSuccess:()-> Unit,
        onFailure:(String)-> Unit
    ){

        favoriteCollection
            .document(uid)
            .collection("items")
            .document(product.proId)
            .set(product)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener {
                onFailure(it.message?:"")
            }
    }

    fun removeFavorite(
        uid:String,
        productId:String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ){
        favoriteCollection
            .document(uid)
            .collection("items")
            .document(productId)
            .delete()
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener {
                onFailure(it.message?:"")
            }
    }

    fun getFavorite(
        uid: String,
        onSuccess: (List<Product>) -> Unit,
        onFailure: (String) -> Unit
    ){
        favoriteCollection
            .document(uid)
            .collection("items")
            .get()
            .addOnSuccessListener {
                onSuccess(it.toObjects(Product::class.java))
            }
            .addOnFailureListener {
                onFailure(it.message?:"")
            }
    }
}