package com.definelab.lifecycel

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    lateinit var firstActivity : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)


        firstActivity = findViewById(R.id.firstActivity)

        firstActivity.setOnClickListener {
            var intent  = Intent(this@SecondActivity,MainActivity::class.java)

            startActivity(intent)
        }

        Log.d("Message","Second Activity OnCreate")


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Message","Second Activity OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Message","Second Activity OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Message","Second Activity OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Message","Second Activity OnStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Message","Second Activity OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Message", "Second Activity OnDestroy")
    }
}