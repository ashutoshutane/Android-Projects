package com.definelab.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class CountriesAdapter(
    var countryName: ArrayList<String>,
    var images: ArrayList<Int>,
    var details: ArrayList<String>,
    var context: Context
) :RecyclerView.Adapter<CountriesAdapter.CountryViewHolder>() {
    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): CountryViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.card_design,p0,false)
        return CountryViewHolder(view)

    }

    override fun onBindViewHolder(
        p0: CountryViewHolder,
        p1: Int
    ) {
        p0.countryName.text = countryName.get(p1)
        p0.details.text = details.get(p1)
        p0.images.setImageResource(images.get(p1))


    }

    override fun getItemCount(): Int {
        return countryName.size
    }

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countryName: TextView = itemView.findViewById(R.id.Name)
        var details: TextView = itemView.findViewById(R.id.details)
        var images: CircleImageView = itemView.findViewById(R.id.profile_image)

    }



}