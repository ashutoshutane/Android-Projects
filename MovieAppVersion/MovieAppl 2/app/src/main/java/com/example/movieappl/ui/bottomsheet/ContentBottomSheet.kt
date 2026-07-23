package com.example.movieappl.ui.bottomsheet


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.example.movieappl.R
import com.example.movieappl.data.local.SavedItem
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ContentBottomSheet(private val item: SavedItem) : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.bottom_sheet_content, container, false)

        val image = view.findViewById<ImageView>(R.id.bsImage)
        val title = view.findViewById<TextView>(R.id.bsTitle)
        val rating = view.findViewById<TextView>(R.id.bsRating)
        val type = view.findViewById<TextView>(R.id.bsType)
        val description = view.findViewById<TextView>(R.id.bsDescription)

        if (item.imageUrl.isNotEmpty()) {
            image.load(item.imageUrl){
                crossfade(true)
            }
        } else {
            image.load(item.imageUrl)
        }
        title.text = item.title
        rating.text = "Rating: ${item.rating}"
        type.text = "Type: ${item.type.uppercase()}"
        description.text = "Description : ${item.description}"

        return view
    }
}