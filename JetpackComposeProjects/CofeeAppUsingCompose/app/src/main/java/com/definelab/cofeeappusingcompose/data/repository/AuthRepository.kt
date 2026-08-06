package com.definelab.cofeeappusingcompose.data.repository

import com.definelab.cofeeappusingcompose.data.remote.FirebaseRepository
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthRepository{

    private val auth = FirebaseRepository.auth

    fun signUp(
        email:String,
        password: String,
        onSuccess:(FirebaseUser)-> Unit,
        onFailure:(String) -> Unit
    ){
        auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
            auth.currentUser?.let {
                user -> onSuccess(user)
            }
        }
            .addOnFailureListener {
                onFailure(it.message ?: "Signup Failed")
            }
    }

    fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ){
        auth.signInWithEmailAndPassword(email,password).addOnSuccessListener {
            onSuccess()
        }
            .addOnFailureListener {
                onFailure(it.message?:"Login Failed")
            }
    }

    fun logout(){
        auth.signOut()
    }

    fun getCurrentUser(): FirebaseUser?{
        return auth.currentUser
    }

    fun getCurrentUserId(): String?{
        return auth.currentUser?.uid
    }


}