package com.definelab.gridview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AnimalAdapter(
    var context: Context,
    var detailList: ArrayList<String>,
    var pictureList: ArrayList<Int>
) : BaseAdapter() {


    override fun getCount(): Int {
        return detailList.size
    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {

        val view : View = LayoutInflater.from(parent?.context).inflate(R.layout.custom_layout,parent,false)

        var animalName : TextView = view.findViewById(R.id.textView)
        var animalImage : ImageView = view.findViewById(R.id.imageView)

        animalName.text = detailList[position]
        animalImage.setImageResource(pictureList[position])

        return view

    }


}