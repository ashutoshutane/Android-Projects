package com.definelab.cofeeappusingcompose.data.repository

import com.definelab.cofeeappusingcompose.data.remote.FirebaseRepository
import com.definelab.cofeeappusingcompose.model.Product
import com.google.firebase.firestore.FirebaseFirestore

class ProductRepository{

    private val firestore = FirebaseRepository.firestore
    private val productsCollection = firestore.collection("products")
    fun getProduct(
        onSuccess:(List<Product>) -> Unit,
        onFailure:(String) -> Unit
    ){
        productsCollection
            .get()
            .addOnSuccessListener {
                val products = it.toObjects(Product::class.java)
                onSuccess(products)
            }
            .addOnFailureListener {
                onFailure(it.message?:"Unable to fetch product")
            }


    }
}