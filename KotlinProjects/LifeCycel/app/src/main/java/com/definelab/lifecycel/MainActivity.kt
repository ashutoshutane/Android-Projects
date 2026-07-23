package com.definelab.lifecycel

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var plusone: Button
    lateinit var secActivity : Button

    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        plusone = findViewById(R.id.plusone)
        secActivity = findViewById(R.id.switchPage)


        plusone.setOnClickListener {
            counter++
            textView.text =""+ counter
        }

        secActivity.setOnClickListener {

            var intent = Intent(this@MainActivity,SecondActivity::class.java)
            startActivity(intent)

        }


        Log.d("Message","First Activity OnCreate")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    override fun onStart() {
        super.onStart()
        Log.d("Message","First Activity OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Message","First Activity OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Message","First Activity OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Message","First Activity OnStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Message","First Activity OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Message", "First Activity OnDestroy")
    }


}