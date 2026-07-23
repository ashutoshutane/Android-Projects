package com.definelab.noteapp.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.db.SupportSQLiteDatabase
import com.definelab.noteapp.Model.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Note::class], version = 1)
abstract class NoteDB: RoomDatabase(){

    abstract fun getNoteDao() : NoteDAO

    //Singleton

    companion object{
        @Volatile
        private var INSTANCE : NoteDB? = null


        fun getDatabase(context: Context , scope: CoroutineScope) : NoteDB{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext, NoteDB::class.java,"note_database")
                    .addCallback(NoteDatabaseCallback(scope))
                    .build()

                INSTANCE = instance

                instance
            }
        }
    }

    private class NoteDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            INSTANCE?.let { database ->
//                database.getNoteDao().insert(Note("t","d"))
                scope.launch {
                    val noteDAO = database.getNoteDao()

                    noteDAO.insert(Note("Title 1","description 1"))
                    noteDAO.insert(Note("Title 2","description 2"))
                    noteDAO.insert(Note("Title 3","description 3"))
                    noteDAO.insert(Note("title 4","description 4"))
                    noteDAO.insert(Note("title 5","description 5"))



                }
            }
        }
    }

}