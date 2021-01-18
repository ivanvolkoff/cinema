package com.example.cinemaworld.presentation.di.movie

import com.example.cinemaworld.domain.usecase.movies.GetMoviesUseCase
import com.example.cinemaworld.domain.usecase.movies.UpdateMovieUseCase
import com.example.cinemaworld.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideArtistViewModelFactort(
        getMoviesUseCase: GetMoviesUseCase,
        updateMovieUseCase: UpdateMovieUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMovieUseCase)
    }

}