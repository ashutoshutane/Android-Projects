package com.definelab.photoalbum.View

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.definelab.photoalbum.R
import com.definelab.photoalbum.databinding.ActivityUpdateImageBinding

class UpdateImageActivity : AppCompatActivity() {

    lateinit var updateImageBinding: ActivityUpdateImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        updateImageBinding = ActivityUpdateImageBinding.inflate(layoutInflater)

        setContentView(updateImageBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        updateImageBinding.imageViewUpdate.setOnClickListener {

        }

        updateImageBinding.updateButoon.setOnClickListener {

        }

        updateImageBinding.updateToolBar.setNavigationOnClickListener {
            finish()
        }


    }
}