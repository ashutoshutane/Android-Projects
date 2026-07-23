package com.definelab.assingment.ui.savedmatches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.definelab.assingment.R
import com.definelab.assingment.adapter.MatchAdapter
import com.definelab.assingment.data.local.DBHelper

class SavedMatchesFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_saved_matches,container,false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        val db = DBHelper(requireContext())
        val list = db.getAllMatches()

//        val tvEmpty = view.findViewById<TextView>(R.id.tvEmpty)
//        if(list.isEmpty()){
//            tvEmpty.visibility = View.VISIBLE
//        }else{
//            tvEmpty.visibility = View.GONE
//        }
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = MatchAdapter(list.toMutableList(), db)
//        recyclerView.adapter = MatchAdapter(list.toMutableList(), db)

        return view
    }
}