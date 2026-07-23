package com.definelab.photoalbum.View

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import com.definelab.photoalbum.Adapter.MyImageAdapter
import com.definelab.photoalbum.R
import com.definelab.photoalbum.ViewModel.ImageViewModel
import com.definelab.photoalbum.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewmodel : ImageViewModel
    lateinit var mainBinding : ActivityMainBinding

    lateinit var myAdapter : MyImageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




        viewmodel = ViewModelProvider(this)[ImageViewModel::class.java]

        mainBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        myAdapter = MyImageAdapter()
        mainBinding.recyclerView.adapter = myAdapter

        viewmodel.getAllImages().observe(this, Observer{
            images ->
            //update ui

            myAdapter.setImage(images)
        })

        mainBinding.floatingActionButton5.setOnClickListener {
            //open AddImageActivity

            val intent = Intent(this, AddImageActivity::class.java)
            startActivity(intent)

        }
    }
}