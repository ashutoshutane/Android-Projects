package com.example.movieappl.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappl.R
import com.example.movieappl.model.Movie

class MovieAdapter(private val list: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.imgMovie)
        val title: TextView = view.findViewById(R.id.tvTitle)
        val rating: TextView = view.findViewById(R.id.tvRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = list[position]

        holder.img.setImageResource(movie.image)
        holder.title.text = movie.title
        holder.rating.text = movie.rating

//        // Heart toggle
//        holder.heart.setOnClickListener {
//            it.isSelected = !it.isSelected
//        }
    }
}