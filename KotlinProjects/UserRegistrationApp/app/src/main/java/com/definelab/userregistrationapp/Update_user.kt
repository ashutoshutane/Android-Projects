
package com.definelab.userregistrationapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.definelab.userregistrationapp.databinding.ActivityMainBinding
import com.definelab.userregistrationapp.databinding.ActivityUpdateUserBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Update_user : AppCompatActivity() {

    lateinit var UpdateUserBinding: ActivityUpdateUserBinding

    val database : FirebaseDatabase = FirebaseDatabase.getInstance()
    val myRef : DatabaseReference = database.reference.child("MyUsers")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        UpdateUserBinding = ActivityUpdateUserBinding.inflate(layoutInflater)
        val view = UpdateUserBinding.root
        setContentView(view)

        supportActionBar?.title = "Update User"

        getAndSetData()

        UpdateUserBinding.buttonUpdateUser.setOnClickListener {
            updateData()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun getAndSetData(){
        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age",0).toString()
        val email = intent.getStringExtra("email")

        UpdateUserBinding.editTextName.setText(name)
        UpdateUserBinding.editTextAge.setText(age)
        UpdateUserBinding.editTextEmailAddress.setText(email)

    }

    fun updateData(){
        val updatedName = UpdateUserBinding.editTextName.text.toString()
        val updateAge = UpdateUserBinding.editTextAge.text.toString().toInt()
        val updateEmail = UpdateUserBinding.editTextEmailAddress.text.toString()
        val userId = intent.getStringExtra("id")

        val userMap = mutableMapOf<String, Any>()
        userMap["userId"] = userId as Any
        userMap["name"] = updatedName
        userMap["age"] = updateAge
        userMap["email"] = updateEmail

        myRef.child(userId).updateChildren(userMap).addOnCompleteListener { task ->
            Toast.makeText(applicationContext,"The user has been updated",Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}