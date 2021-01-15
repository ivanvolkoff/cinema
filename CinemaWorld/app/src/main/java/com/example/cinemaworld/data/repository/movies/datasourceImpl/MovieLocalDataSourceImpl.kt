package com.example.cinemaworld.data.repository.movies.datasourceImpl

import com.example.cinemaworld.data.db.MovieDao
import com.example.cinemaworld.data.model.movie.Movie
import com.example.cinemaworld.data.repository.movies.datasource.MovieCacheDataSource
import com.example.cinemaworld.data.repository.movies.datasource.MovieLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao:MovieDao):
    MovieLocalDatasource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getMovies()
    }

    override suspend fun saveMovieToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}