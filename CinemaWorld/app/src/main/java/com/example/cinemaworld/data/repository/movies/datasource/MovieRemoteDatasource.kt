package com.example.cinemaworld.data.repository.movies.datasource

import com.example.cinemaworld.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies():Response<MovieList>
}