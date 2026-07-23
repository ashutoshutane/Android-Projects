package com.example.movieappl.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappl.R
import com.example.movieappl.data.local.DBHelper
import com.example.movieappl.data.local.SavedItem
import com.example.movieappl.ui.bottomsheet.ContentBottomSheet

class ContentAdapter(
    private val list: List<SavedItem>,
    private val db: DBHelper,
    private val onRefresh: () -> Unit
) : RecyclerView.Adapter<ContentAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img = view.findViewById<ImageView>(R.id.imgMovie)
        val title = view.findViewById<TextView>(R.id.tvTitle)
        val rating  = view.findViewById<TextView>(R.id.tvRating)
        val heart = view.findViewById<ImageView>(R.id.imgHeart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = list[position]

        holder.img.setImageResource(item.imageRes)
        holder.title.text = item.title
        holder.rating.text = item.rating


        // ✅ Check saved state
        val isSaved = db.isSaved(item.id, item.type)

        holder.heart.setImageResource(
            if (isSaved) R.drawable.favorite_filled_24
            else R.drawable.favorite_24px
        )

        holder.heart.setOnClickListener {
            // ✅ Check saved state

//            Log.d("HEART", "Clicked: ${item.title}")
           if(db.isSaved(item.id,item.type)){
               db.delete(item.id,item.type)
               Toast.makeText(holder.itemView.context,"${item.title} removed from saved", Toast.LENGTH_SHORT).show()
           }else{
               db.insert(
                   SavedItem(item.id,item.title,item.imageRes,item.rating,item.type,item.description)
               )

               Toast.makeText(holder.itemView.context,"${item.title} added to Saved", Toast.LENGTH_SHORT).show()
           }
            notifyItemChanged(position)

            onRefresh()

        }


        holder.itemView.setOnLongClickListener{

            val bottomSheet = ContentBottomSheet(
                SavedItem(
                    item.id,
                    item.title,
                    item.imageRes,
                    item.rating,
                    item.type,
                    item.description
                )
            )

            val activity = holder.itemView.context as AppCompatActivity
            bottomSheet.show(activity.supportFragmentManager,"BOTTOM_SHEET")

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