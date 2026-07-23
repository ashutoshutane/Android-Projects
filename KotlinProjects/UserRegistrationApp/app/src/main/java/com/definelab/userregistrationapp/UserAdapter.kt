package com.definelab.userregistrationapp

import android.content.Context
import android.content.Intent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.definelab.userregistrationapp.databinding.UserItemBinding

class UserAdapter(var context : Context,
                  var userList: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: UserViewHolder,
        position: Int
    ) {
        holder.adapterBinding.textViewName.text = userList[position].name
        holder.adapterBinding.textViewAge.text = userList[position].age.toString()
        holder.adapterBinding.textViewEmail.text = userList[position].email

        holder.adapterBinding.LinearLayout.setOnClickListener {
            val intent = Intent(context, Update_user::class.java)
            intent.putExtra("id",userList[position].userId)
            intent.putExtra("name",userList[position].name)
            intent.putExtra("age",userList[position].age)
            intent.putExtra("email",userList[position].email)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun getUserId(position: Int) :String{
        return userList[position].userId
    }

    inner class UserViewHolder(val adapterBinding : UserItemBinding) : RecyclerView.ViewHolder(adapterBinding.root){}
}