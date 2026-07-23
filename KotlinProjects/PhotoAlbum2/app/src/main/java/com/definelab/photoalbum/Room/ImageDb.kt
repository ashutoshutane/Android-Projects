package com.definelab.photoalbum.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.definelab.photoalbum.Model.MyImage

@Database(entities = [MyImage::class] , version = 1)
abstract class ImageDb : RoomDatabase() {

    // According to the document the database class should follow three conditions
    //1. it must be annotated with @Database
    //2. Database class must be an abstract class that extends the Room database class
    //3. The dbclass must have abstract method that have zero argument and return the object of dao class

    abstract fun myImageDao() : ImageDao

    //singleton design pattern
    companion object{

        @Volatile
        private var instance : ImageDb?= null

        fun getDatabaseObject(context: Context) : ImageDb {
            synchronized(this){
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ImageDb::class.java,
                        "My_album"
                    ).build()
                }
                return instance as ImageDb
            }
        }
    }
}