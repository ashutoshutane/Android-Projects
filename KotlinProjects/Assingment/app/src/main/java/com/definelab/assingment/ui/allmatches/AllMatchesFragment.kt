package com.definelab.assingment.ui.allmatches

import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.definelab.assingment.R
import com.definelab.assingment.adapter.MatchAdapter
import com.definelab.assingment.data.local.DBHelper
import com.definelab.assingment.data.model.Venue
import com.definelab.assingment.data.remote.RetrofitClient
import com.definelab.assingment.utils.Constant
import kotlinx.coroutines.launch

class AllMatchesFragment: Fragment(){
    private  lateinit var adapter: MatchAdapter
    private lateinit var db: DBHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_all_matches,container,false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        db = DBHelper(requireContext())
        adapter = MatchAdapter(mutableListOf(),db)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        fetchData()

        return view
    }

    private fun fetchData(){

//        val dummylist = listOf(
//            Venue("1", "Football match"),
//            Venue("2", "Cricket match"),
//            Venue("3", "Hockey match"),
//            Venue("4", "Basketball match"),
//            Venue("5", "tennis match"),
//        )
        lifecycleScope.launch {
            val response = RetrofitClient.api.getVenues(
                Constant.LOCATION,
                Constant.TOKEN,
                Constant.VERSION
            )
                Log.d("API DEBUG",response.body().toString())
            if (response.isSuccessful){
                response.body()?.response?.venue?.let {
                    adapter.updateList(it)
                }
            }
        }
//        adapter.updateList(dummylist)
    }
}