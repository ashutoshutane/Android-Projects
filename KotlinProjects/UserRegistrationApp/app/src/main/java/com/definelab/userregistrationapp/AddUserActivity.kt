package com.definelab.userregistrationapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.definelab.userregistrationapp.databinding.ActivityAddUserBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class AddUserActivity : AppCompatActivity() {

    lateinit var addUserBinding: ActivityAddUserBinding

    val database : FirebaseDatabase = FirebaseDatabase.getInstance()
    val myRef : DatabaseReference = database.reference.child("MyUsers")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        addUserBinding = ActivityAddUserBinding.inflate(layoutInflater)
        val view = addUserBinding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        supportActionBar?.title = "Add User"
        addUserBinding.buttonadduser.setOnClickListener {
            addUserToDatbase()
        }
    }

    fun addUserToDatbase(){
        val name = addUserBinding.editTextName.text.toString()
        val age = addUserBinding.editTextAge.text.toString().toInt()
        val email = addUserBinding.editTextEmailAddress.text.toString()
        val id : String = myRef.push().key.toString() //for unique id

        //Creating the object of the data class

        val user = User(id,name,age,email)

        //Saving the data to the database

        myRef.child(id).setValue(user).addOnCompleteListener { task ->
            if(task.isSuccessful){
                Toast.makeText(applicationContext,"The new user has been added to the database",
                    Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(applicationContext,"Error: ${task.exception.toString()}",Toast.LENGTH_SHORT).show()
            }
        } // we use set function to store the value in the database

    }

}