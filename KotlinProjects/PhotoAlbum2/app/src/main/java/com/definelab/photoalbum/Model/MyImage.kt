package com.definelab.photoalbum.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_Image")
class MyImage(
    val imageTitle : String,
    val imageDescription : String,
    //BLOB -> Binary Large Object
    //String

    val imageAsString : String
) {
    @PrimaryKey(autoGenerate = true)
    var imageId = 0



}