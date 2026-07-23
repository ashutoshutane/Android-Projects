package com.definelab.todolist

import android.content.Context
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class FileHelper {
    val fileName = "listinfo.dat"

    fun writeData(item: ArrayList<String>, context: Context
    ) {
        var fos : FileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE)
        var oas = ObjectOutputStream(fos)
        oas.writeObject(item)
        oas.close()
    }

    fun readData(context: Context) : ArrayList<String>{

        var itemList : ArrayList<String>
        try {
            var fis : FileInputStream = context.openFileInput(fileName)
            var ois = ObjectInputStream(fis)
            itemList = ois.readObject() as ArrayList<String>
            return itemList
        }catch (e: Exception){
            itemList = ArrayList()
            return itemList

        }

    }
}