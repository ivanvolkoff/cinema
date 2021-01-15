package com.example.cinemaworld.domain.usecase.tvShows

import com.example.cinemaworld.data.model.tvShow.TvShow
import com.example.cinemaworld.domain.repository.TvShowsReposytory

class GetTvShowsUseCase(private val tvShowsReposytory: TvShowsReposytory) {
    suspend fun execute(): List<TvShow>? = tvShowsReposytory.getTvShows()
}