package com.example.cinemaworld.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.cinemaworld.domain.usecase.tvShows.GetTvShowsUseCase
import com.example.cinemaworld.domain.usecase.tvShows.UpdateTvShows

class TvShowViewModel(private val getTvShowsUseCase: GetTvShowsUseCase,
private val updateTvShows: UpdateTvShows) : ViewModel(){

    fun getTvShows() = liveData {
        val tvshowsList = getTvShowsUseCase.execute()
        emit(tvshowsList)
    }

    fun updateTvShows() = liveData {
        val tvshowsList = updateTvShows.execute()
        emit(tvshowsList)
    }
}