package com.example.cinemaworld.data.repository.movies

import android.util.Log
import com.example.cinemaworld.data.model.movie.Movie
import com.example.cinemaworld.data.repository.movies.datasource.MovieCacheDataSource
import com.example.cinemaworld.data.repository.movies.datasource.MovieLocalDatasource
import com.example.cinemaworld.data.repository.movies.datasource.MovieRemoteDatasource
import com.example.cinemaworld.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDatasource: MovieLocalDatasource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {


    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
       val newListOfMovies = getMoviesFromAPI()
        movieLocalDatasource.clearAll()
        movieLocalDatasource.saveMovieToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val respone = movieRemoteDatasource.getMovies()
            val body = respone.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        return movieList

    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDatasource.getMoviesFromDB()

        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDatasource.saveMovieToDB(movieList)
        }

        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()

        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }
}