package com.example.cinemaworld.data.repository.tvShows.datasource

import com.example.cinemaworld.data.model.movie.MovieList
import com.example.cinemaworld.data.model.tvShow.TvShowsList
import retrofit2.Response

interface TvShowsRemoteDatasource {
    suspend fun getTvShows():Response<TvShowsList>
}