package com.example.movieappl.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappl.R
import com.example.movieappl.data.local.DBHelper
import com.example.movieappl.model.Category

class CategoryAdapter(
    private val list: List<Category>,
    private val db: DBHelper,
    private val onRefresh: () -> Unit
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tvCategory)
        val rv: RecyclerView = view.findViewById(R.id.rvMovies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = list[position]

        holder.title.text = category.title

        holder.rv.layoutManager =
            LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)

        holder.rv.adapter = ContentAdapter(category.list, db, onRefresh)
    }
}









//old

//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.movieappl.R
//import com.example.movieappl.data.model.Category
//
//class CategoryAdapter(private val list: List<Category>) :
//    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
//
//    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val title: TextView = view.findViewById(R.id.tvCategory)
//        val rvMovies: RecyclerView = view.findViewById(R.id.rvMovies)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_category, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun getItemCount() = list.size
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val category = list[position]
//
//        holder.title.text = category.title
//
//        holder.rvMovies.layoutManager =
//            LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
//
//        holder.rvMovies.adapter = MovieAdapter(category.movies)
//    }
//}