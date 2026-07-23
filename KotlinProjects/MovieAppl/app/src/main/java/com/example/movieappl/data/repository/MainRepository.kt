package com.example.movieappl.data.repository

import com.example.movieappl.data.remote.ApiService
import com.example.movieappl.data.remote.dto.toUI
import com.example.movieappl.model.Category
import com.example.movieappl.utils.Constants

class MainRepository(
    private val api: ApiService
) {

    suspend fun getMovieCategories(
        apiKey: String
    ): List<Category> {

        val trending = api
            .getTrendingMovies(apiKey)
            .results

        val popular = api
            .getPopularMovies(apiKey)
            .results

        val newMovies = api
            .getNewMovies(apiKey)
            .results

        return listOf(
            Category(
                "Trending Movies",
                trending.map { it.toUI() }
            ),

            Category(
                "Popular Movies",
                popular.map { it.toUI() }
            ),

            Category(
                "New Movies",
                newMovies.map { it.toUI() }
            )
        )
    }

    suspend fun getSeriesCategories(
        apiKey: String
    ): List<Category> {

        val trending = api
            .getTrendingSeries(apiKey)
            .results

        val popular = api
            .getPopularSeries(apiKey)
            .results

        val newSeries = api
            .getNewSeries(apiKey)
            .results

        return listOf(
            Category(
                "Trending Series",
                trending.map { it.toUI() }
            ),

            Category(
                "Popular Series",
                popular.map { it.toUI() }
            ),

            Category(
                "New Series",
                newSeries.map { it.toUI() }
            )
        )
    }

    suspend fun search(
        query: String,
        page: Int
    ) = api.searchMulti(
        Constants.API_KEY,
        query,
        page
    )
}