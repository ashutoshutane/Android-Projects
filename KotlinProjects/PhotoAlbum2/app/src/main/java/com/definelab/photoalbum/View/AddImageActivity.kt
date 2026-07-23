package com.definelab.photoalbum.View

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.definelab.photoalbum.Model.MyImage
import com.definelab.photoalbum.R
import com.definelab.photoalbum.ViewModel.ImageViewModel
import com.definelab.photoalbum.databinding.ActivityAddImageBinding
import com.definelab.photoalbum.util.ControlPermission
import com.definelab.photoalbum.util.ConvertImage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.jar.Manifest

class AddImageActivity : AppCompatActivity() {

    lateinit var addImageBinding: ActivityAddImageBinding
    lateinit var activityResultLauncherForSelectImage: ActivityResultLauncher<Intent>
    lateinit var selectImage : Bitmap
    lateinit var myImageViewModel : ImageViewModel
    var control = false





    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        addImageBinding = ActivityAddImageBinding.inflate(layoutInflater)

        setContentView(addImageBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        myImageViewModel = ViewModelProvider(this)[ImageViewModel::class.java]


    registerActivityForSelectImage()


    addImageBinding.addImageView.setOnClickListener {
        if(ControlPermission.checkPermission(this)){
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            //startActivityForResult -> Before API 30
            activityResultLauncherForSelectImage.launch(intent)
        }else{
            if(Build.VERSION.SDK_INT>=33){
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.READ_MEDIA_IMAGES),
                    1
                )
            }else{
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                    1
                )
            }
        }
    }

    addImageBinding.button.setOnClickListener {

        if(control){

            addImageBinding.button.text = "Uploading image please wait........."
            addImageBinding.button.isEnabled = false

            GlobalScope.launch(Dispatchers.IO) {
                val title = addImageBinding.editTextTitle.text.toString()
                val description = addImageBinding.editTextdescription.text.toString()
                println("desc "+description)
                val imgAsString = ConvertImage.convertToString(selectImage)

                if(imgAsString!=null){
                    myImageViewModel.insert(MyImage(title,description,imgAsString))
                    control = false
                    finish()
                }else{
                    Toast.makeText(applicationContext,"There is a problem please select a new image", Toast.LENGTH_SHORT).show()
                }
            }


        }else{
            Toast.makeText(applicationContext,"Please select a Photo", Toast.LENGTH_SHORT).show()
        }



    }

    addImageBinding.toolbarAddImage.setNavigationOnClickListener {
        finish()
    }

    }

    fun registerActivityForSelectImage(){
     activityResultLauncherForSelectImage = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
         result->
         //result of the intent

         val resultCode = result.resultCode
         val imageData = result.data

         if (resultCode==RESULT_OK && imageData!=null) {
             val imageUrl = imageData.data

             imageUrl?.let {
                 selectImage = if (Build.VERSION.SDK_INT >= 28) {
                     val imageSource = ImageDecoder.createSource(this.contentResolver, it)
                     ImageDecoder.decodeBitmap(imageSource)
                 }else{
                     MediaStore.Images.Media.getBitmap(this.contentResolver, imageUrl)
                 }

                 addImageBinding.addImageView.setImageBitmap(selectImage)
                 control = true
             }
         }
     }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String?>,
        grantResults: IntArray,
        deviceId: Int
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults, deviceId)

        if(requestCode == 1 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            //startActivityForResult -> Before API 30
            activityResultLauncherForSelectImage.launch(intent)
        }
    }
}