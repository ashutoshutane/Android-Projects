package com.definelab.photoalbum.Repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.definelab.photoalbum.Model.MyImage
import com.definelab.photoalbum.Room.ImageDao
import com.definelab.photoalbum.Room.ImageDb
import kotlinx.coroutines.flow.Flow


class ImageRepository(application: Application) {

    var imageDao : ImageDao
    var imageList : LiveData<List<MyImage>>

    init {
        val database = ImageDb.getDatabaseObject(application)
        imageDao = database.myImageDao()
        imageList = imageDao.getAllImages()

    }

    suspend fun insert(myImage: MyImage){
        imageDao.insert(myImage)
    }

    suspend fun delete(myImage: MyImage){
        imageDao.delete(myImage)
    }

    suspend fun update(myImage: MyImage){
        imageDao.update(myImage)
    }

    suspend fun deleteAllImages(){
        imageDao.deleteAllImage()
    }

    fun getAllImages() : LiveData<List<MyImage>>{
        return imageDao.getAllImages()
    }

}