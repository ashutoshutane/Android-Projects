package com.example.movieappl.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieappl.data.repository.MainRepository

class ViewModelFactory(
    private val repo: MainRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repo) as T
        }

        throw IllegalArgumentException(
            "Unknown ViewModel class"
        )
    }
}