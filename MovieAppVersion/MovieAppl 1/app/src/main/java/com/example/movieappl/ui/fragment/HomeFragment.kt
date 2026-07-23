package com.example.movieappl.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappl.R
import com.example.movieappl.data.local.DBHelper
import com.example.movieappl.data.local.SavedItem
import com.example.movieappl.model.Category
import com.example.movieappl.model.ContentUI
import com.example.movieappl.ui.adapter.CategoryAdapter
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var db: DBHelper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        val rv = view.findViewById<RecyclerView>(R.id.rvCategory)

        db = DBHelper(requireContext())

        rv.layoutManager = LinearLayoutManager(requireContext())

        // MOVIES
        val movies = listOf(
            SavedItem(1,"Avengers",R.drawable.theavengers,"8.4","movie","Earth mightest hero"),
            SavedItem( 2,"Interstellar",R.drawable.interstellar, "8.7","movie","Travel space"),
            SavedItem( 3,"Transformers",R.drawable.transformers, "7.5","movie","Space Robots"),
            SavedItem( 4,"Godzilla",R.drawable.godziilla, "7.2","movie","War of titans")
        )

        // SERIES
        val series = listOf(
            SavedItem(1,"Dark", R.drawable.dhurandhar, "8.8","series",""),
            SavedItem(2,"Money Heist",R.drawable.dhurandhar2,  "8.3","series",""),
            SavedItem( 3,"Breaking Bad",R.drawable.theavengers, "9.1","series",""),
            SavedItem(4,"Stranger Things",R.drawable.interstellar,  "8.9","series","")
        )

        // CATEGORY LIST
        val movieCategories = listOf(
            Category("Trending Movies",movies),
            Category("Popular Movies", movies),
            Category("New Movies", movies)
        )

        val seriesCategories = listOf(
            Category("Trending Series", series),
            Category("Top Series", series),
            Category("New Series", series)
        )

        //Default
        rv.adapter = CategoryAdapter(movieCategories, db) {
            // optional refresh
        }




        tabLayout.addTab(tabLayout.newTab().setText("Movies"))
        tabLayout.addTab(tabLayout.newTab().setText("Series"))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                if (tab.position == 0) {
                    rv.adapter = CategoryAdapter(movieCategories,db){}
                } else {
                    rv.adapter = CategoryAdapter(seriesCategories,db){}
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }
}


//old
//
//
//import android.os.Bundle
//import android.view.View
//import androidx.fragment.app.Fragment
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.movieappl.R
//import com.example.movieappl.data.model.Category
//import com.example.movieappl.data.model.Movie
//import com.example.movieappl.ui.adapter.CategoryAdapter
//import com.google.android.material.tabs.TabLayout
//
//class HomeFragment : Fragment(R.layout.fragment_home) {
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//
//        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
//        val rv = view.findViewById<RecyclerView>(R.id.rvCategory)
//
//        tabLayout.addTab(tabLayout.newTab().setText("Movies"))
//        tabLayout.addTab(tabLayout.newTab().setText("Series"))
//
//        val movies = listOf(
//            Movie(R.drawable.theavengers, "Avengers", "8.4"),
//            Movie(R.drawable.interstellar, "Interstellar", "8.7"),
//            Movie(R.drawable.transformers, "Transformers", "7.5"),
//            Movie(R.drawable.godziilla, "Godzilla", "7.2"),
//            Movie(R.drawable.dhurandhar, "Dhurandhar", "6.9"),
//            Movie(R.drawable.dhurandhar2, "Dhurandhar 2", "7.1")
//        )
//
//        val categoryList = listOf(
//            Category("Trending", movies,),
//            Category("Upcoming", movies),
//            Category("Top Rated", movies),
//            Category("New", movies)
//        )
//
//        rv.layoutManager = LinearLayoutManager(requireContext())
//        rv.adapter = CategoryAdapter(categoryList)
//    }
//}