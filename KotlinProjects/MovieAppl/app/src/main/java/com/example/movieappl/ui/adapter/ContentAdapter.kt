package com.example.movieappl.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.movieappl.R
import com.example.movieappl.data.local.SavedItem
import com.example.movieappl.model.ContentUI
import com.example.movieappl.ui.bottomsheet.ContentBottomSheet

class ContentAdapter(
    private var list: List<ContentUI>,
    private var savedSet: Set<String>,
    private val onHeartClick: (ContentUI) -> Unit,
    private val onLoadMore: (() -> Unit)? = null
) : RecyclerView.Adapter<ContentAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.imgMovie)
        val title: TextView = view.findViewById(R.id.tvTitle)
        val rating: TextView = view.findViewById(R.id.tvRating)
        val heart: ImageView = view.findViewById(R.id.imgHeart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    fun submitList(
        newList: List<ContentUI>,
        newSavedSet: Set<String>
    ) {
        list = newList
        savedSet = newSavedSet
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (position >= list.size - 5) {
            onLoadMore?.invoke()
        }

        val item = list[position]

        holder.title.text = item.title
        holder.rating.text = item.rating

        holder.img.load(item.imageUrl) {
            crossfade(true)
        }

        val key = "${item.id}_${item.type}"

        val isSaved = savedSet.contains(key)

        holder.heart.setImageResource(
            if (isSaved)
                R.drawable.favorite_filled_24
            else
                R.drawable.favorite_24px
        )

        holder.heart.setOnClickListener {
            onHeartClick(item)
        }

        // LONG PRESS → BOTTOM SHEET
        holder.itemView.setOnLongClickListener {

            val bottomSheet = ContentBottomSheet(
                SavedItem(
                    item.id,
                    item.title,
                    item.imageUrl,
                    item.rating,
                    item.type,
                    item.description
                )
            )

            val activity = holder.itemView.context as AppCompatActivity

            bottomSheet.show(
                activity.supportFragmentManager,
                "BOTTOM_SHEET"
            )

            true
        }
    }
}



































// old
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.movieappl.R
//import com.example.movieappl.data.local.DBHelper
//import com.example.movieappl.data.local.SavedItem
//import com.example.movieappl.model.ContentUI
//
//class ContentAdapter(private val list: List<ContentUI>, private val context: Context) :
//    RecyclerView.Adapter<ContentAdapter.ViewHolder>() {
//
//    private val db = DBHelper(context)
//    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//
//        val img = view.findViewById<ImageView>(R.id.imgMovie)
//        val title = view.findViewById<TextView>(R.id.tvTitle)
//        val rating = view.findViewById<TextView>(R.id.tvRating)
//        val heart = view.findViewById<ImageView>(R.id.imgHeart)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_movie, parent, false)
//        return ViewHolder(view)
//    }
//
//
//    override fun getItemCount() = list.size
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = list[position]
//
//        holder.img.setImageResource(item.image)
//        holder.title.text = item.title
//
//        Thread{
//            val saved = db.isSaved(item.id,item.type)
//            holder.itemView.post{
//                holder.heart.isSelected = saved
//            }
//        }.start()
//
//        holder.heart.setOnClickListener {
//            it.animate().scaleX(1.3f).scaleY(1.3f).setDuration(150).withEndAction {
//                it.animate().scaleX(1f).scaleY(1f).duration = 150
//            }
//            Thread{
//                val saved = db.isSaved(item.id,item.type)
//                if (saved){
//                    db.delete(item.id,item.type)
//                }else{
//                    db.insert(SavedItem(item.id, item.title, item.image, item.rating, item.type))
//                }
//
//                holder.itemView.post {
//                    holder.heart.isSelected = !saved
//                }
//
//            }.start()
//        }
//
//    }
//}
