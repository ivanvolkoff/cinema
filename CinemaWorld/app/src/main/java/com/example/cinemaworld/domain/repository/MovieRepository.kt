package com.example.cinemaworld.domain.repository

import com.example.cinemaworld.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}