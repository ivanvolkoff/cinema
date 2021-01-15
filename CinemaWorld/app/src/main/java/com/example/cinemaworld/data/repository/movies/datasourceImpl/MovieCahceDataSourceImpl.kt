package com.example.cinemaworld.data.repository.movies.datasourceImpl

import com.example.cinemaworld.data.model.movie.Movie
import com.example.cinemaworld.data.repository.movies.datasource.MovieCacheDataSource

class MovieCahceDataSourceImpl : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }


}