package com.definelab.intent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.MainScope

class MainActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var age: EditText
    lateinit var send: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        name = findViewById(R.id.editTextName)
        age = findViewById(R.id.editTextAge)
        send = findViewById(R.id.button)

        send.setOnClickListener {

            var username : String = name.text.toString()
            var userage : Int = age.text.toString().toInt()



            var intent = Intent(this@MainActivity,SecondActivity::class.java)
            intent.putExtra("username",username)
            intent.putExtra("userage",userage)
            startActivity(intent)

        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}