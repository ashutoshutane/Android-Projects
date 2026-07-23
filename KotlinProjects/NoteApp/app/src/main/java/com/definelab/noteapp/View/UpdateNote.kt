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

class UpdateNote : AppCompatActivity() {

    lateinit var updateNoteTitle : EditText
    lateinit var updateNoteDescription : EditText
    lateinit var cancelUpdate : Button
    lateinit var update : Button

    var currentId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_update_note)

        supportActionBar?.title = "Update Note"

        updateNoteTitle = findViewById<EditText>(R.id.editTextUpdateNoteTitle)
        updateNoteDescription = findViewById<EditText>(R.id.editTextUpdateNoteDescription)
        cancelUpdate = findViewById<Button>(R.id.buttonUpdateCancel)
        update = findViewById<Button>(R.id.buttonUpdate)

        getAndSetData()

        cancelUpdate.setOnClickListener {
            Toast.makeText(applicationContext,"No update operation was performed", Toast.LENGTH_SHORT).show()
            finish()
        }

        update.setOnClickListener {
            updateNote()
            Toast.makeText(applicationContext,"Note Updated successfully", Toast.LENGTH_SHORT).show()
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    fun updateNote(){
        val updatedTitle = updateNoteTitle.text.toString()
        println(updatedTitle)
        val updatedDescription = updateNoteDescription.text.toString()
        println(updatedDescription)
        val intent = Intent()
        intent.putExtra("updatedTitle",updatedTitle)
        intent.putExtra("updatedDescription",updatedDescription)

        if(currentId!=-1){
            intent.putExtra("currentId",currentId)
            setResult(RESULT_OK,intent)
            finish()
        }

    }

    fun getAndSetData(){

        //get
        val currentTitle = intent.getStringExtra("currentNote")
//        println(currentTitle)
        val currentDescription = intent.getStringExtra("currentDescription")
//        println(currentDescription)
        currentId = intent.getIntExtra("currentId",-1)

        //set
        updateNoteTitle.setText(currentTitle)
        updateNoteDescription.setText(currentDescription)

    }

}