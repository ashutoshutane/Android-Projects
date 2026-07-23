package com.example.movieappl.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappl.R
import com.example.movieappl.data.local.SavedItem

class SavedAdapter(private val list: List<SavedItem>): RecyclerView.Adapter<SavedAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val img = view.findViewById<ImageView>(R.id.imgMovie)
        val title = view.findViewById< TextView>(R.id.tvTitle)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val item = list[position]
        holder.img.setImageResource(item.imageRes)
        holder.title.text = item.title
    }

    override fun getItemCount(): Int {
        return list.size
    }





}