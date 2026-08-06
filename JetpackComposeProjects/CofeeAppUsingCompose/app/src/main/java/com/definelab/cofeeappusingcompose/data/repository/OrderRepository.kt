package com.definelab.cofeeappusingcompose.data.repository

import android.widget.Toast
import com.definelab.cofeeappusingcompose.data.remote.FirebaseRepository
import com.definelab.cofeeappusingcompose.model.Orders

class OrderRepository{

    private val firestore = FirebaseRepository.firestore

    fun placeOrder(
        orders: Orders,
        onSuccess:(String) -> Unit,
        onFailure:(String) -> Unit
    ){
        firestore.collection("orders")
            .document(orders.uid)
            .set(orders)
            .addOnSuccessListener {
                onSuccess("Order placed SuccessFully")
            }
            .addOnFailureListener {
                onFailure(it.message?:"Error Occurred")
            }

    }

    fun getOrder(
        uid:String,
        onSuccess: (List<Orders>) -> Unit,
        onFailure: (String) -> Unit
    ){
        firestore.collection("orders")
            .whereEqualTo("userId",uid)
            .get()
            .addOnSuccessListener {
                onSuccess(it.toObjects(Orders::class.java))
            }
            .addOnFailureListener {
                onFailure(it.message?:"")
            }

    }
}