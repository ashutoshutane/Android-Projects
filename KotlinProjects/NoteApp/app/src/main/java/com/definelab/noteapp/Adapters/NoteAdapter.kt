package com.definelab.noteapp.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.definelab.noteapp.Model.Note
import com.definelab.noteapp.R
import com.definelab.noteapp.View.MainActivity
import com.definelab.noteapp.View.NoteAddActivity
import com.definelab.noteapp.View.UpdateNote

class NoteAdapter(private val activity: MainActivity) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: NoteViewHolder,
        position: Int
    ) {
        var currentNote : Note = notes[position]
        holder.textViewTitle.text = currentNote.title
        holder.textViewDescription.text = currentNote.description
        holder.cardView.setOnClickListener {
            val intent = Intent(activity, UpdateNote::class.java)
            intent.putExtra("currentNote",currentNote.title)
            intent.putExtra("currentDescription",currentNote.description)
            intent.putExtra("currentId",currentNote.id)

            activity.updateActivityResultLauncher.launch(intent)

        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun setNote(myNote : List<Note>){
        this.notes = myNote
        notifyDataSetChanged()
    }

    fun getNote(position: Int) : Note{
        return notes[position]
    }

    var notes : List<Note> = ArrayList()
    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val textViewTitle : TextView = itemView.findViewById(R.id.textViewTitle)
        val textViewDescription : TextView = itemView.findViewById(R.id.textViewDescription)
        val cardView : CardView = itemView.findViewById(R.id.CardView)


    }

}