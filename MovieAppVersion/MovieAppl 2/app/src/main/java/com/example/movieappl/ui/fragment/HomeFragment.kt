package com.example.movieappl.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappl.R
import com.example.movieappl.data.local.DBHelper
import com.example.movieappl.data.remote.RetrofitClient
import com.example.movieappl.data.repository.MainRepository
import com.example.movieappl.model.Category
import com.example.movieappl.ui.adapter.CategoryAdapter
import com.example.movieappl.viewmodel.HomeViewModel
import com.example.movieappl.viewmodel.ViewModelFactory
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var viewModel: HomeViewModel

    private lateinit var rv: RecyclerView

    private lateinit var db: DBHelper

    private lateinit var searchView: SearchView

    private lateinit var adapter: CategoryAdapter

    private var currentCategories = emptyList<Category>()

    private var currentSavedSet = emptySet<String>()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(view, savedInstanceState)

        rv = view.findViewById(R.id.rvCategory)

        rv.layoutManager =
            LinearLayoutManager(requireContext())

        db = DBHelper(requireContext())

        val repo =
            MainRepository(RetrofitClient.api)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(repo)
        )[HomeViewModel::class.java]

        searchView =
            requireActivity().findViewById(R.id.searchView)

        adapter = CategoryAdapter(
            emptyList(),
            emptySet(),
            onHeartClick = { item ->
                viewModel.toogleSave(db, item)
            },
            onRefresh = {
                viewModel.loadNextSearchPage()
            }
        )

        rv.adapter = adapter

        observeData()

        setupTabs()

        setupSearch()

        viewModel.refreshSaved(db)
    }

    private fun observeData() {

        viewModel.savedSet.observe(viewLifecycleOwner) {

            currentSavedSet = it

            adapter.submitlist(
                currentCategories,
                currentSavedSet
            )
        }

        viewModel.movies.observe(viewLifecycleOwner) {

            currentCategories = it

            adapter.submitlist(
                currentCategories,
                currentSavedSet
            )
        }

        viewModel.series.observe(viewLifecycleOwner) {

            currentCategories = it

            adapter.submitlist(
                currentCategories,
                currentSavedSet
            )
        }

        viewModel.searchResult.observe(viewLifecycleOwner) {

            currentCategories =
                listOf(
                    Category(
                        "Search Results",
                        it
                    )
                )

            adapter.submitlist(
                currentCategories,
                currentSavedSet
            )
        }
    }

    private fun setupTabs() {

        val tabLayout =
            requireView().findViewById<TabLayout>(R.id.tabLayout)

        if (tabLayout.tabCount == 0) {

            tabLayout.addTab(
                tabLayout.newTab().setText("Movies")
            )

            tabLayout.addTab(
                tabLayout.newTab().setText("Series")
            )
        }

        tabLayout.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener {

                override fun onTabSelected(tab: TabLayout.Tab?) {

                    when (tab?.position) {

                        0 -> {
                            searchView.setQuery("", false)
                            searchView.clearFocus()
                            viewModel.loadMovie()
                        }

                        1 -> {
                            searchView.setQuery("", false)
                            searchView.clearFocus()
                            viewModel.loadSeries()
                        }
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {}

                override fun onTabReselected(tab: TabLayout.Tab?) {}
            }
        )

        viewModel.loadMovie()
    }

    private fun setupSearch() {

        searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {

                    val q = query.orEmpty().trim()

                    if (q.isNotEmpty()) {
                        viewModel.search(q)
                    }

                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    val q = newText.orEmpty().trim()

                    if (q.isNotEmpty()) {

                        viewModel.search(q)

                    } else {

                        viewModel.loadMovie()
                    }

                    return true
                }
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        db.close()
    }
}








// old
//import android.os.Bundle
//import android.view.View
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.ViewModelProvider
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.movieappl.R
//import com.example.movieappl.data.local.DBHelper
//import com.example.movieappl.data.local.SavedItem
//import com.example.movieappl.data.repository.Repository
//import com.example.movieappl.model.Category
//import com.example.movieappl.model.ContentUI
//import com.example.movieappl.ui.adapter.CategoryAdapter
//import com.example.movieappl.viewmodel.HomeViewModel
//import com.example.movieappl.viewmodel.ViewModelFactory
//import com.google.android.material.tabs.TabLayout

//class HomeFragment : Fragment(R.layout.fragment_home) {
//
//    private lateinit var viewModel: HomeViewModel
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//
//        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
//        val rv = view.findViewById<RecyclerView>(R.id.rvCategory)
//
//        val db = DBHelper(requireContext())
//
//        val repo = Repository(db)
//
//        val factory = ViewModelFactory(repo)
//
//        viewModel = ViewModelProvider(this,factory)[HomeViewModel::class.java]
//
//        rv.layoutManager = LinearLayoutManager(requireContext())
//
//        tabLayout.addTab(tabLayout.newTab().setText("Movies"))
//        tabLayout.addTab(tabLayout.newTab().setText("Series"))
//
//        viewModel.movies.observe(viewLifecycleOwner){
//            rv.adapter = CategoryAdapter(listOf(Category("Movies",it)),db){
//
//            }
//        }
//
//        viewModel.series.observe(viewLifecycleOwner){
//            rv.adapter = CategoryAdapter(listOf(Category("Series",it)),db){
//
//            }
//        }
//
//        viewModel.loadMovie()
//
//        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                if(tab?.position ==0 ) viewModel.loadMovie()
//                else viewModel.loadSeries()
//            }
//
//            override fun onTabUnselected(p0: TabLayout.Tab?) {}
//
//            override fun onTabSelected(p0: TabLayout.Tab?) {}
//
//        })
//        // MOVIES
//        val movies = listOf(
//            SavedItem(1,"Avengers",R.drawable.theavengers,"8.4","movie","Earth's mightiest heroes must come together to stop Loki."),
//            SavedItem( 2,"Interstellar",R.drawable.interstellar, "8.7","movie","A team travels through a wormhole in space to save humanity."),
//            SavedItem( 3,"Transformers",R.drawable.transformers, "7.5","movie",""),
//            SavedItem( 4,"Godzilla",R.drawable.godziilla, "7.2","movie","")
//        )
//
//        // SERIES
//        val series = listOf(
//            SavedItem(1,"Dark", R.drawable.dhurandhar, "8.8","series",""),
//            SavedItem(2,"Money Heist",R.drawable.dhurandhar2,  "8.3","series",""),
//            SavedItem( 3,"Breaking Bad",R.drawable.theavengers, "9.1","series",""),
//            SavedItem(4,"Stranger Things",R.drawable.interstellar,  "8.9","series","")
//        )
//
//        // CATEGORY LIST
//        val movieCategories = listOf(
//            Category("Trending Movies",movies),
//            Category("Popular Movies", movies),
//            Category("New Movies", movies)
//        )
//
//        val seriesCategories = listOf(
//            Category("Trending Series", series),
//            Category("Top Series", series),
//            Category("New Series", series)
//        )

        //Default
//        rv.adapter = CategoryAdapter(movieCategories, db) {
//            // optional refresh
//        }
//
//
//
//
//        tabLayout.addTab(tabLayout.newTab().setText("Movies"))
//        tabLayout.addTab(tabLayout.newTab().setText("Series"))
//
//        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab) {
//                if (tab.position == 0) {
//                    rv.adapter = CategoryAdapter(movieCategories,db){}
//                } else {
//                    rv.adapter = CategoryAdapter(seriesCategories,db){}
//                }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab) {}
//            override fun onTabReselected(tab: TabLayout.Tab) {}
//        })
//    }
//    override fun onDestroy() {
//        super.onDestroy()
//        db.close()
 // }
//}


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