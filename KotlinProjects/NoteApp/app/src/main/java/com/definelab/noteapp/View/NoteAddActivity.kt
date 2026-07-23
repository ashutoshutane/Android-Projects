package com.definelab.noteapp.View

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.definelab.noteapp.R

class NoteAddActivity : AppCompatActivity() {

    lateinit var noteTitle : EditText
    lateinit var noteDescription : EditText
    lateinit var buttonCancel : Button
    lateinit var buttonSave : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_note_add)

        supportActionBar?.title = "Add Note"

        noteTitle = findViewById<EditText>(R.id.editTextNoteTitle)
        noteDescription = findViewById<EditText>(R.id.editTextDescription)
        buttonSave = findViewById<Button>(R.id.buttonSave)
        buttonCancel = findViewById<Button>(R.id.buttonCancel)


        buttonCancel.setOnClickListener {
            Toast.makeText(applicationContext,"Nothing Saved", Toast.LENGTH_SHORT).show()
            finish() //close the page
        }

        buttonSave.setOnClickListener {
            saveNote()

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun saveNote(){
        val noteTitle : String = noteTitle.text.toString()
        val noteDescription : String = noteDescription.text.toString()

        val intent = Intent()
        intent.putExtra("title",noteTitle)
        intent.putExtra("description",noteDescription)
        setResult(RESULT_OK,intent)
        finish()

    }
}