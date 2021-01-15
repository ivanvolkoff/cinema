package com.example.cinemaworld.domain.repository

import com.example.cinemaworld.data.model.tvShow.TvShow

interface TvShowsReposytory {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}