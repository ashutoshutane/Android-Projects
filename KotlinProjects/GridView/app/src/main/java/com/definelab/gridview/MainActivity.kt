package com.definelab.gridview

import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var gridView: GridView

    var pictureList = ArrayList<Int>()
    var detailList = ArrayList<String>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        gridView = findViewById(R.id.gridView)

        fillArrays()

        val adapter = AnimalAdapter(this,detailList,pictureList)
        gridView.adapter = adapter


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun fillArrays() {
        detailList.add("Bird")
        detailList.add("Dog")
        detailList.add("Cat")
        detailList.add("snake")
        detailList.add("Rabbit")
        detailList.add("cow")
        detailList.add("Horse")
        detailList.add("Lion")
        detailList.add("Tiger")
        detailList.add("Elephant")


        pictureList.add(R.drawable.bird)
        pictureList.add(R.drawable.dog)
        pictureList.add(R.drawable.cat)
        pictureList.add(R.drawable.cow)
        pictureList.add(R.drawable.snake)
        pictureList.add(R.drawable.lion)
        pictureList.add(R.drawable.horse)
        pictureList.add(R.drawable.rabbit)
        pictureList.add(R.drawable.tiger)
        pictureList.add(R.drawable.elephant)

    }

}