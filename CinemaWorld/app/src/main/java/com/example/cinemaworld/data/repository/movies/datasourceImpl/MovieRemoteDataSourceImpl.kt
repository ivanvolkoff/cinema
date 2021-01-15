package com.example.cinemaworld.data.repository.movies.datasourceImpl

import com.example.cinemaworld.data.api.TMDBService
import com.example.cinemaworld.data.model.movie.MovieList
import com.example.cinemaworld.data.repository.movies.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService
,private val apiKey: String) : MovieRemoteDatasource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}