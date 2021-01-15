package com.example.cinemaworld.domain.usecase.movies

import com.example.cinemaworld.data.model.movie.Movie
import com.example.cinemaworld.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie>? = movieRepository.getMovies()
}