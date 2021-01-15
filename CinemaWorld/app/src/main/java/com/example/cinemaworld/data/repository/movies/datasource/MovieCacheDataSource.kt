package com.example.cinemaworld.data.repository.movies.datasource

import com.example.cinemaworld.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>

    suspend fun saveMoviesToCache(movies: List<Movie>)


}