package com.definelab.cofeeappusingcompose.data.repository

import com.definelab.cofeeappusingcompose.data.remote.FirebaseRepository
import com.definelab.cofeeappusingcompose.model.CartItems
import com.google.rpc.QuotaFailure

class CartRepository{

    private val firestore = FirebaseRepository.firestore

    fun addToCart(
        uid: String,
        items: CartItems,
        onSuccess:()-> Unit,
        onFailure: (String) -> Unit
    ){
        firestore.collection("cart")
            .document(uid)
            .collection("items")
            .document(items.productId)
            .set(items)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener {
                onFailure(it.message?:"")
            }
    }

    fun getCartItems(
        uid: String,
        onSuccess: (List<CartItems>) -> Unit,
        onFailure: (String) -> Unit
    ){
        firestore.collection("cart")
            .document(uid)
            .collection("items")
            .get()
            .addOnSuccessListener {
                onSuccess(it.toObjects(CartItems::class.java))
            }
            .addOnFailureListener {
                onFailure(it.message ?:"")
            }

    }

    fun removeCartItems(
        uid: String,
        productId:String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ){
        firestore.collection("cart")
            .document(uid)
            .collection("items")
            .document(productId)
            .delete()
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener {
                onFailure(it.message?: "")
            }

    }

}