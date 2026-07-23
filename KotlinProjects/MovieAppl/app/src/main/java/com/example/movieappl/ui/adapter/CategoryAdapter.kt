package com.example.movieappl.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappl.R
import com.example.movieappl.model.Category
import com.example.movieappl.model.ContentUI

class CategoryAdapter(
    private var list: List<Category>,
    private var savedSet: Set<String>,
    private val onHeartClick: (ContentUI) -> Unit,
    private val onLoadMore: (() -> Unit)? = null
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private val childAdapters = mutableMapOf<String, ContentAdapter>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tvCategory)
        val rv: RecyclerView = view.findViewById(R.id.rvMovies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    fun submitList(
        newList: List<Category>,
        newSavedSet: Set<String>
    ) {
        list = newList
        savedSet = newSavedSet
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val category = list[position]

        holder.title.text = category.title

        if (holder.rv.layoutManager == null) {
            holder.rv.layoutManager =
                LinearLayoutManager(
                    holder.itemView.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
        }

        val adapter = childAdapters.getOrPut(category.title) {

            ContentAdapter(
                emptyList(),
                savedSet,
                onHeartClick,
                onLoadMore
            )
        }

        adapter.submitList(category.list, savedSet)

        holder.rv.adapter = adapter
    }
}