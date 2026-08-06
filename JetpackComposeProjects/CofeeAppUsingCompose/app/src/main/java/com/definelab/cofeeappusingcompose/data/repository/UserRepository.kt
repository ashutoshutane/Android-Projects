package com.definelab.cofeeappusingcompose.data.repository

import com.definelab.cofeeappusingcompose.data.remote.FirebaseRepository
import com.definelab.cofeeappusingcompose.model.User
import com.google.firebase.firestore.FirebaseFirestore

class UserRepository{
    private val firestore = FirebaseRepository.firestore
    private val usersCollection  = firestore.collection("users")

    fun saveUser(
        user: User,
        onSuccess:() -> Unit,
        onFailure:(String) ->Unit
    ){
        usersCollection
            .document(user.uid)
            .set(user)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener {
                onFailure(it.message ?:"Failed")
            }

    }

    fun getUser(
        uid: String,
        onSuccess: (User) -> Unit,
        onFailure: (String) -> Unit
    ){
        usersCollection
            .document(uid)
            .get()
            .addOnSuccessListener {
                val user = it.toObject(User::class.java)

                if(user!=null){
                    onSuccess(user)
                }else{
                    onFailure("User not Found")
                }
            }
            .addOnFailureListener {
                onFailure(it.message ?:"Failed")
            }

    }

    fun updateUser(
        user: User,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ){
        usersCollection
            .document(user.uid)
            .set(user)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener {
                onFailure(it.message?:"Update Failed")
            }
    }

    fun deleteUser(
        uid: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ){
        usersCollection
            .document(uid)
            .delete()
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener {
                onFailure(it.message ?: "Delete Failed")
            }
    }
}