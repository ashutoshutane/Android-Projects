package com.definelab.photoalbum.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.definelab.photoalbum.Model.MyImage
import com.definelab.photoalbum.Repository.ImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImageViewModel(application: Application) : AndroidViewModel(application) {

    var repository : ImageRepository
    var imageList : LiveData<List<MyImage>>

    init {
        repository = ImageRepository(application)
        imageList = repository.getAllImages()

    }

    fun insert(myImage: MyImage) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(myImage)
    }

    suspend fun update(myImage: MyImage) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(myImage)
    }

    suspend fun delete(myImage: MyImage) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(myImage)
    }

    fun getAllImages() : LiveData<List<MyImage>>{
        return imageList
    }
}