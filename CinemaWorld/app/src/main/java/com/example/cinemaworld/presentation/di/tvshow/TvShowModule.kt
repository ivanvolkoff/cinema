package com.example.cinemaworld.presentation.di.tvshow

import com.example.cinemaworld.domain.usecase.movies.GetMoviesUseCase
import com.example.cinemaworld.domain.usecase.movies.UpdateMovieUseCase
import com.example.cinemaworld.domain.usecase.tvShows.GetTvShowsUseCase
import com.example.cinemaworld.domain.usecase.tvShows.UpdateTvShows
import com.example.cinemaworld.presentation.movie.MovieViewModelFactory
import com.example.cinemaworld.presentation.tvshows.TvShowsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvshowScope
    @Provides
    fun provideTvshowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
       updateTvShows: UpdateTvShows
    ): TvShowsViewModelFactory {
        return TvShowsViewModelFactory(getTvShowsUseCase, updateTvShows)
    }

}