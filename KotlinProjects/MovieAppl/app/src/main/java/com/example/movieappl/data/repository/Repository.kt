package com.example.movieappl.data.repository

import com.example.movieappl.data.local.DBHelper
import com.example.movieappl.data.local.SavedItem
import com.example.movieappl.data.remote.RetrofitClient
import com.example.movieappl.data.remote.dto.toUI
import com.example.movieappl.model.Category
import com.example.movieappl.utils.Constants

class Repository(private val db: DBHelper) {

    // ================= MOVIES =================
    suspend fun getMovieCategories(): List<Category> {

        val trending = RetrofitClient.api.getTrendingMovies(Constants.API_KEY).results
        val popular = RetrofitClient.api.getPopularMovies(Constants.API_KEY).results
        val new = RetrofitClient.api.getNewMovies(Constants.API_KEY).results

        return listOf(
            Category("Trending Movies", trending.map { it.toUI() }),
            Category("Popular Movies", popular.map { it.toUI() }),
            Category("New Movies", new.map { it.toUI() })
        )
    }

    // ================= SERIES =================
    suspend fun getSeriesCategories(): List<Category> {

        val trending = RetrofitClient.api.getTrendingSeries(Constants.API_KEY).results
        val popular = RetrofitClient.api.getPopularSeries(Constants.API_KEY).results
        val new = RetrofitClient.api.getNewSeries(Constants.API_KEY).results

        return listOf(
            Category("Trending Series", trending.map { it.toUI() }),
            Category("Popular Series", popular.map { it.toUI() }),
            Category("New Series", new.map { it.toUI() })
        )
    }

    // ================= LOCAL DB =================
    fun insert(item: SavedItem) = db.insert(item)

    fun delete(id: Int, type: String) = db.delete(id, type)

    fun getSaved(): List<SavedItem> = db.getAll()

    fun isSaved(id: Int, type: String): Boolean = db.isSaved(id, type)
}