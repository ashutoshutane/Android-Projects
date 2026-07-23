package com.example.movieappl.viewmodel

import android.R.attr.apiKey
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappl.data.local.DBHelper
import com.example.movieappl.data.local.SavedItem
import com.example.movieappl.data.remote.dto.toUI
import com.example.movieappl.data.repository.MainRepository
import com.example.movieappl.data.repository.Repository
import com.example.movieappl.model.Category
import com.example.movieappl.model.ContentUI
import com.example.movieappl.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel(private val repo : MainRepository): ViewModel() {
    private val _movies = MutableLiveData<List<Category>>()
    val movies : LiveData<List<Category>> = _movies

    private val _series = MutableLiveData<List<Category>>()
    val series : LiveData<List<Category>> = _series

    private val _serchResult = MutableLiveData<List<ContentUI>>()
    val searchResult : LiveData<List<ContentUI>> = _serchResult

    private val _savedSet = MutableLiveData<Set<String>>(emptySet())
    val savedSet : LiveData<Set<String>> = _savedSet

    private var currentSearchQuery = ""
    private var currentSearchPage = 0
    private var totalSearchPages = 1
    private var isSearchLoading = false

    private val loadSearchItems = mutableListOf<ContentUI>()

    private var searchJob : Job? = null


    fun loadMovie(){
        viewModelScope.launch {
            try {
                _movies.value = repo.getMovieCategories(Constants.API_KEY)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun loadSeries(){
        viewModelScope.launch {
            try {
                _series.value = repo.getSeriesCategories(Constants.API_KEY)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun search(query:String){
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(400)
            currentSearchQuery = query
            currentSearchPage = 0
            totalSearchPages = 1
            isSearchLoading = false
            loadSearchItems.clear()

            _serchResult.value = emptyList()

        }
    }

    fun loadNextSearchPage(){
        val query = currentSearchQuery

        if(query.isBlank()) return

        if(isSearchLoading) return

        if(currentSearchPage >= totalSearchPages) return

        val nextPage = currentSearchPage + 1

        isSearchLoading = true

        viewModelScope.launch {
            try {
                val result = repo.search(query,nextPage)

                currentSearchPage = result.page
                totalSearchPages = result.totalPages

                val nextItems = result.results
                    .filter {
                        it.media_type == "movie" || it.media_type == "tv"
                    }
                    .map {
                        it.toUI()
                    }

                nextItems.forEach { item->
                    val exists = loadSearchItems.any{
                        it.id == item.id && it.type == item.type
                    }

                    if(!exists){
                        loadSearchItems.add(item)
                    }
                }

                _serchResult.value = loadSearchItems.toList()
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                isSearchLoading = false
            }
        }
    }

    fun refreshSaved(db: DBHelper){
        viewModelScope.launch(Dispatchers.IO){
            val saved = db.getAll()
                .map {
                    "${it.id}_${it.type}"
                }
                .toSet()

            _savedSet.postValue(saved)
        }
    }

    fun toogleSave(db: DBHelper,item: ContentUI){

        viewModelScope.launch(Dispatchers.IO){
            if(db.isSaved(item.id,item.type)){
                db.delete(item.id,item.type)
            }else{
                db.insert(
                    SavedItem(
                        item.id,
                        item.title,
                        item.imageUrl,
                        item.rating,
                        item.type,
                        item.description
                    )
                )
            }
            refreshSaved(db)
        }

    }
}