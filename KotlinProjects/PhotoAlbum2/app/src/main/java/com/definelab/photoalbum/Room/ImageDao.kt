package com.definelab.photoalbum.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.definelab.photoalbum.Model.MyImage

@Dao
interface ImageDao {

    @Insert
    suspend fun insert(myImage: MyImage)

    @Delete
    suspend fun delete(myImage: MyImage)

    @Update
    suspend fun update(myImage: MyImage)

    @Query("Delete from my_Image")
    suspend fun deleteAllImage()

    @Query("Select * from my_Image")
    fun getAllImages() : LiveData<List<MyImage>>
}