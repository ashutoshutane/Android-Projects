package com.definelab.noteapp.View

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.definelab.noteapp.Adapters.NoteAdapter
import com.definelab.noteapp.Model.Note
import com.definelab.noteapp.NoteApplication
import com.definelab.noteapp.R
import com.definelab.noteapp.ViewModel.NoteViewModel
import com.definelab.noteapp.ViewModel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: NoteViewModel
    //for add
    lateinit var addActivityResultLauncher: ActivityResultLauncher<Intent>
    //for update
    lateinit var  updateActivityResultLauncher : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.RecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val noteAdapter = NoteAdapter(this)
        recyclerView.adapter = noteAdapter

        registerActivityResultLauncher()

        val viewModelFactory = NoteViewModelFactory((application as NoteApplication).repository)

        viewModel = ViewModelProvider(this,viewModelFactory).get(NoteViewModel::class.java)

        viewModel.allMyNotes.observe(this, Observer{
            notes ->
            //update ui
            noteAdapter.setNote(notes)
        })

        ItemTouchHelper(object:ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                TODO("Not yet implemented")
            }

            override fun onSwiped(
                viewHolder: RecyclerView.ViewHolder,
                direction: Int
            ) {
                viewModel.delete(noteAdapter.getNote(viewHolder.adapterPosition))
            }

        }).attachToRecyclerView(recyclerView)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

    fun registerActivityResultLauncher(){

        addActivityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback{ resultAddNote ->

                val resultCode = resultAddNote.resultCode
                val data = resultAddNote.data

                if(resultCode == RESULT_OK && data != null){
                    val noteTitle : String = data.getStringExtra("title").toString()
                    val noteDescription : String = data.getStringExtra("description").toString()

                    val note = Note(noteTitle, noteDescription)
                    viewModel.insert(note)
                }



            })

        updateActivityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult(),{
            resultUpdateNote ->

            val resultCode = resultUpdateNote.resultCode
            val data = resultUpdateNote.data

            if(resultCode == RESULT_OK && data != null){
                val updatedTitle : String = data.getStringExtra("updatedTitle").toString()
                val updatedDescription : String = data.getStringExtra("updatedDescription").toString()
                val noteId = data.getIntExtra("currentId",-1)

                Log.d("UPDATE_DEBUG" , "ID = $noteId")
                Log.d("UPDATE_DEBUG" , "TITLE = $updatedTitle")
                Log.d("UPDATE_DEBUG" , "DESCRIPTION = $updatedDescription")

                val newNote = Note(updatedTitle,updatedDescription)
                newNote.id = noteId

                viewModel.update(newNote)
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.new_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.AddNote ->{
                val intent = Intent(this, NoteAddActivity::class.java)
                addActivityResultLauncher.launch(intent)
            }

            R.id.DeleteNote -> showDialogMessage()
        }
        return true
    }

    fun showDialogMessage(){
        val dialogMessage = AlertDialog.Builder(this)
        dialogMessage.setTitle("Delete All Notes")
        dialogMessage.setMessage("if clicked yes all notes will be get deleted , if you want to delete a specific note , please swipe left or right")
        dialogMessage.setNegativeButton("No", DialogInterface.OnClickListener{ dialog, which ->
            dialog.cancel()

        })

        dialogMessage.setPositiveButton("Yes" , DialogInterface.OnClickListener{dialog, which ->
            viewModel.deleteAllNotes()
        })
        dialogMessage.create().show()
    }
}