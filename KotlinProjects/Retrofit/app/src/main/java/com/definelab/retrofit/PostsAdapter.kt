package com.definelab.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.definelab.retrofit.databinding.PostsItemBinding

class PostsAdapter(var postsList: ArrayList<Posts>) : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostsViewHolder {
        val binding = PostsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostsViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PostsViewHolder,
        position: Int
    ) {
        holder.adapterBinding.UserId.text = postsList[position].userId.toString()
        holder.adapterBinding.Id.text = postsList[position].id.toString()
        holder.adapterBinding.title.text = postsList[position].title
        holder.adapterBinding.Body.text = postsList[position].subtitle

    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    inner class PostsViewHolder(val adapterBinding: PostsItemBinding)
        : RecyclerView.ViewHolder(adapterBinding.root){

        }



}