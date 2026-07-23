package com.definelab.firebase

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    lateinit var edittext : EditText
    lateinit var button : Button

    lateinit var textView : TextView

    lateinit var Ename : TextView



    val database : FirebaseDatabase = FirebaseDatabase.getInstance()
    val myRef : DatabaseReference = database.reference.child("Users")
    val ref2 : DatabaseReference = database.reference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        edittext = findViewById(R.id.editTextName)
        button = findViewById(R.id.buttonsend)
        textView = findViewById(R.id.textViewName)
        Ename = findViewById(R.id.textViewEname)
        ref2.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val realname : String = snapshot.child("Users").child("name").value.toString()
                textView.text = realname

                val empname : String = snapshot.child("employee").child("name").value.toString()
                Ename.text = empname
            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        button.setOnClickListener {
            val username : String = edittext.text.toString()
            myRef.child("username").setValue(username)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}