package com.example.cinemaworld.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cinemaworld.domain.usecase.tvShows.GetTvShowsUseCase
import com.example.cinemaworld.domain.usecase.tvShows.UpdateTvShows

class TvShowsViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShows: UpdateTvShows
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowsUseCase, updateTvShows) as T
    }
}