package com.example.cinemaworld.data.repository.movies.datasource

import com.example.cinemaworld.data.model.movie.Movie

interface MovieLocalDatasource {

    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMovieToDB(movies:List<Movie>)
    suspend fun clearAll()
}