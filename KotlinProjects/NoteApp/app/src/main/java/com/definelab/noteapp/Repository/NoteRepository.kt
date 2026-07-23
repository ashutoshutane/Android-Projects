package com.definelab.noteapp.Repository

import androidx.annotation.WorkerThread
import com.definelab.noteapp.Model.Note
import com.definelab.noteapp.Room.NoteDAO
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao: NoteDAO) {

    val allMyNotes : Flow<List<Note>> = noteDao.getAllNotes()

    @WorkerThread
    suspend fun insert(note: Note){
        noteDao.insert(note)
    }

    @WorkerThread
    suspend fun delete(note: Note){
        noteDao.delete(note)
    }

    @WorkerThread
    suspend fun update(note: Note){
        noteDao.update(note)
    }

    @WorkerThread
    suspend fun deleteAllNotes(){
        noteDao.deleteAllNotes()
    }




}