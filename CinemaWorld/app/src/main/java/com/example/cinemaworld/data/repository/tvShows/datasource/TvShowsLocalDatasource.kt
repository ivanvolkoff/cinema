package com.example.cinemaworld.data.repository.tvShows.datasource

import com.example.cinemaworld.data.model.movie.Movie
import com.example.cinemaworld.data.model.tvShow.TvShow

interface TvShowsLocalDatasource {

    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(movies:List<TvShow>)
    suspend fun clearAll()
}