package com.example.cinemaworld.data.repository.tvShows.datasource

import com.example.cinemaworld.data.model.movie.Movie
import com.example.cinemaworld.data.model.tvShow.TvShow

interface TvShowsCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>

    suspend fun saveTvShowsToCache(movies: List<TvShow>)


}