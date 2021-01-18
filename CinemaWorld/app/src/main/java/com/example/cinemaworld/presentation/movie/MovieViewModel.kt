package com.example.cinemaworld.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.cinemaworld.domain.usecase.movies.GetMoviesUseCase
import com.example.cinemaworld.domain.usecase.movies.UpdateMovieUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
):ViewModel() {

    fun getMovies()= liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovieList() = liveData {
        val movieList = updateMovieUseCase.execute()
        emit(movieList)
    }
}