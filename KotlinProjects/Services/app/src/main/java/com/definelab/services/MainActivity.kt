package com.definelab.services

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var startclassicService: Button
    lateinit var startjobintentservice: Button
    lateinit var stopservice: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        startclassicService = findViewById(R.id.StartClassicService)
        startjobintentservice = findViewById(R.id.Startjobintentservice)
        stopservice = findViewById(R.id.StopService)


        startclassicService.setOnClickListener {
            val intent = Intent(this@MainActivity, ClassicServiceExample::class.java)
            startService(intent)


        }

        startjobintentservice.setOnClickListener {

        }

        stopservice.setOnClickListener {

        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}