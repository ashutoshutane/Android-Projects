package com.definelab.noteapp

import android.app.Application
import com.definelab.noteapp.Repository.NoteRepository
import com.definelab.noteapp.Room.NoteDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class NoteApplication : Application() {


    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { NoteDB.getDatabase(this,applicationScope) }
    val repository by lazy { NoteRepository(database.getNoteDao()) }
}