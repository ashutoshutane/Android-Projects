package com.definelab.assingment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.definelab.assingment.R
import com.definelab.assingment.data.local.DBHelper
import com.definelab.assingment.data.model.Venue

class MatchAdapter(private var list: MutableList<Venue>,private val db: DBHelper):
        RecyclerView.Adapter<MatchAdapter.ViewHolder>(){
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
      val name: TextView = view.findViewById(R.id.tvName)
        val star: ImageView = view.findViewById(R.id.ivStar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.name.text = item.name

        if(db.isSaved(item.id)){
            holder.star.setImageResource(R.drawable.star_filled)
        }else{
            holder.star.setImageResource(R.drawable.star_border)
        }

        holder.star.setOnClickListener {
            if(db.isSaved(item.id)){
                db.deleteMatch(item.id)
                holder.star.setImageResource(R.drawable.star_border)
            }else{
                db.insertMatch(item.id, item.name)
                holder.star.setImageResource(R.drawable.star_filled)
            }
        }
    }

    fun updateList(newList: List<Venue>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
        }