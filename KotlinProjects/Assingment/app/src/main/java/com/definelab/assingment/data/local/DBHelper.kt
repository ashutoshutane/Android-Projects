package com.definelab.assingment.data.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.definelab.assingment.data.model.Venue

class DBHelper(context: Context): SQLiteOpenHelper(context,"matches.db",null,1){

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE saved_matches(id TEXT PRIMARY KEY, name TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    fun insertMatch(id: String, name: String){
        writableDatabase.execSQL("INSERT OR REPLACE INTO saved_matches VALUES(?,?)", arrayOf(id,name))
    }

    fun deleteMatch(id: String) {
        writableDatabase.execSQL("DELETE FROM saved_matches WHERE id = ?", arrayOf(id))
    }

    fun isSaved(id:String): Boolean{
    val cursor = readableDatabase.rawQuery(
        "SELECT * FROM saved_matches WHERE id = ?",
        arrayOf(id)
    )

    val exists = cursor.count > 0
    cursor.close()
    return exists
}

    fun getAllMatches(): List<Venue>{
        val list = mutableListOf<Venue>()
        val cursor = readableDatabase.rawQuery(
        "SELECT * FROM saved_matches",
        null
    )

        while (cursor.moveToNext()){
            list.add(Venue(cursor.getString(0),cursor.getString(1)))
        }
        cursor.close()
        return list
    }
}