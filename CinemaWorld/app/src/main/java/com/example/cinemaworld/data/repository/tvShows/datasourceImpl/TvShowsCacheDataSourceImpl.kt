package com.example.cinemaworld.data.repository.tvShows.datasourceImpl

import com.example.cinemaworld.data.model.movie.Movie
import com.example.cinemaworld.data.model.tvShow.TvShow
import com.example.cinemaworld.data.repository.tvShows.datasource.TvShowsCacheDataSource

class TvShowsCacheDataSourceImpl : TvShowsCacheDataSource {
    private var tvShowsList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowsList
    }

    override suspend fun saveTvShowsToCache(movies: List<TvShow>) {
        tvShowsList.clear()
        tvShowsList = ArrayList(tvShowsList)
    }
}