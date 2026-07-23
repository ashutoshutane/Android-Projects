package com.example.movieappl.ui.fragment



import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappl.R
import com.example.movieappl.data.local.DBHelper
import com.example.movieappl.data.remote.RetrofitClient
import com.example.movieappl.data.repository.MainRepository
import com.example.movieappl.model.Category
import com.example.movieappl.model.ContentUI
import com.example.movieappl.ui.adapter.CategoryAdapter
import com.example.movieappl.viewmodel.HomeViewModel
import com.example.movieappl.viewmodel.ViewModelFactory

class SavedFragment : Fragment(R.layout.fragment_saved) {

    private lateinit var db: DBHelper

    private lateinit var rv: RecyclerView

    private lateinit var tvEmpty: TextView

    private lateinit var adapter: CategoryAdapter

    private lateinit var viewModel: HomeViewModel

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(view, savedInstanceState)

        db = DBHelper(requireContext())

        rv = view.findViewById(R.id.rvSaved)

        tvEmpty = view.findViewById(R.id.tvEmpty)

        rv.layoutManager =
            LinearLayoutManager(requireContext())

        val repo =
            MainRepository(RetrofitClient.api)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(repo)
        )[HomeViewModel::class.java]

        adapter = CategoryAdapter(
            emptyList(),
            emptySet(),
            onHeartClick = { item ->

                viewModel.toogleSave(db, item)
            }
        )

        rv.adapter = adapter

        observeSaved()

        viewModel.refreshSaved(db)
    }

    private fun observeSaved() {

        viewModel.savedSet.observe(viewLifecycleOwner) {

            loadSavedData(it)
        }
    }

    private fun loadSavedData(savedSet: Set<String>) {

        val all = db.getAll()

        val savedList = all.map {

            ContentUI(
                id = it.id,
                title = it.title,
                imageUrl = it.imageUrl,
                rating = it.rating,
                type = it.type,
                description = it.description,
                date = ""
            )
        }

        val movies =
            savedList.filter {
                it.type == "movie"
            }

        val series =
            savedList.filter {
                it.type == "series"
            }

        val categories = mutableListOf<Category>()

        if (movies.isNotEmpty()) {

            categories.add(
                Category(
                    "Saved Movies",
                    movies
                )
            )
        }

        if (series.isNotEmpty()) {

            categories.add(
                Category(
                    "Saved Series",
                    series
                )
            )
        }

        if (categories.isEmpty()) {

            tvEmpty.visibility = View.VISIBLE

            rv.visibility = View.GONE

        } else {

            tvEmpty.visibility = View.GONE

            rv.visibility = View.VISIBLE

            adapter.submitlist(
                categories,
                savedSet
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        db.close()
    }
}














//class SavedFragment : Fragment(R.layout.fragment_saved) {
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//
//        val rv = view.findViewById<RecyclerView>(R.id.rvSaved)
//        val db = DBHelper(requireContext())
//
//        rv.layoutManager = LinearLayoutManager(requireContext())
//
//        Thread{
//            val list = db.getAll()
//
//            requireActivity().runOnUiThread{
//                rv.adapter = SavedAdapter(list)
//            }
//        }.start()
//
////        val savedMovies = listOf(
////            ContentUI( R.drawable.theavengers, "Avengers","8.4"),
////            ContentUI(R.drawable.interstellar,"Interstellar",  "8.7"),
////            ContentUI(R.drawable.interstellar,"Interstellar",  "8.7")
////        )
////
////        val savedSeries = listOf(
////            ContentUI(R.drawable.dhurandhar,"Dark",  "8.8"),
////            ContentUI(R.drawable.dhurandhar2,"Money Heist",  "8.3"),
////            ContentUI(R.drawable.interstellar,"Interstellar",  "8.7")
////        )
////
////        val categories = listOf(
////            Category("Saved Movies", savedMovies),
////            Category("Saved Series", savedSeries)
////        )
////
////        rv.layoutManager = LinearLayoutManager(requireContext())
////        rv.adapter = CategoryAdapter(categories)
//    }
//}