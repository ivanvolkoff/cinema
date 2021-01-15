package com.example.cinemaworld.domain.usecase.tvShows

import com.example.cinemaworld.data.model.tvShow.TvShow
import com.example.cinemaworld.domain.repository.TvShowsReposytory

class UpdateTvShows(private val tvShowsReposytory: TvShowsReposytory) {
    suspend fun execute(): List<TvShow>? = tvShowsReposytory.updateTvShows()
}