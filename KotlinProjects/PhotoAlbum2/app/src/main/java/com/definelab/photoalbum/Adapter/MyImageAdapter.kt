package com.definelab.photoalbum.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.definelab.photoalbum.Model.MyImage
import com.definelab.photoalbum.databinding.ImageItemBinding
import com.definelab.photoalbum.util.ConvertImage
import kotlinx.serialization.builtins.ArraySerializer

class MyImageAdapter: RecyclerView.Adapter<MyImageAdapter.MyImageViewHolder>() {

    var imageList : List<MyImage> = ArrayList()

    fun setImage(images: List<MyImage>){
        this.imageList= images
        notifyDataSetChanged()
    }
    class MyImageViewHolder(val itemBinding: ImageItemBinding): RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyImageViewHolder {

        val view = ImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyImageViewHolder(view)

    }

    override fun onBindViewHolder(
        holder: MyImageViewHolder,
        position: Int
    ) {
        var myImage = imageList[position]
        with(holder){
            itemBinding.textViewTitle.text = myImage.imageTitle
            itemBinding.textViewDescription.text = myImage.imageDescription

            val imageAsBitmap = ConvertImage.convertToBitMap(myImage.imageAsString)
            itemBinding.imageView.setImageBitmap(imageAsBitmap)
        }
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

}