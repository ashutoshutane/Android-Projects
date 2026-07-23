package com.example.movieappl.data.local

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, "movie_db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("""
            CREATE TABLE saved_items (
                id INTEGER,
                title TEXT,
                imageUrl TEXT,
                rating TEXT,
                type TEXT,
                description TEXT,
                PRIMARY KEY(id, type)
            )
        """)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS saved_items")
        onCreate(db)
    }

    fun insert(item: SavedItem) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("id", item.id)
            put("title", item.title)
            put("imageUrl", item.imageUrl)
            put("rating", item.rating)
            put("type", item.type)
            put("description", item.description)
        }

        db.insertWithOnConflict(
            "saved_items",
            null,
            values,
            SQLiteDatabase.CONFLICT_REPLACE
        )
        db.close()
    }

    fun delete(id: Int, type: String) {
        writableDatabase.delete(
            "saved_items",
            "id=? AND type=?",
            arrayOf(id.toString(), type)
        )
    }

    fun isSaved(id: Int, type: String): Boolean {
        val c = readableDatabase.rawQuery(
            "SELECT * FROM saved_items WHERE id=? AND type=?",
            arrayOf(id.toString(), type)
        )
        val exists = c.moveToFirst()
        c.close()
        return exists
    }

    fun getAll(): List<SavedItem> {
        val list = mutableListOf<SavedItem>()
        val c = readableDatabase.rawQuery("SELECT * FROM saved_items", null)

        while (c.moveToNext()) {
            list.add(
                SavedItem(
                    c.getInt(0),
                    c.getString(1),
                    c.getString(2),
                    c.getString(3),
                    c.getString(4),
                    c.getString(5)
                )
            )
        }

        c.close()
        return list
    }
}