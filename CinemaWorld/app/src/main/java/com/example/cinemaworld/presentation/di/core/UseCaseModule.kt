package com.example.cinemaworld.presentation.di.core

import com.example.cinemaworld.domain.repository.ArtistsRepository
import com.example.cinemaworld.domain.repository.MovieRepository
import com.example.cinemaworld.domain.repository.TvShowsReposytory
import com.example.cinemaworld.domain.usecase.artists.GetArtistsUseCase
import com.example.cinemaworld.domain.usecase.artists.UpdateArtistsUseCase
import com.example.cinemaworld.domain.usecase.movies.GetMoviesUseCase
import com.example.cinemaworld.domain.usecase.movies.UpdateMovieUseCase
import com.example.cinemaworld.domain.usecase.tvShows.GetTvShowsUseCase
import com.example.cinemaworld.domain.usecase.tvShows.UpdateTvShows
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    @Singleton
    fun providesGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }


    @Provides
    @Singleton
    fun provideMovieUpdateUseCase(movieRepository: MovieRepository): UpdateMovieUseCase {
        return UpdateMovieUseCase(movieRepository)
    }

    @Provides
    @Singleton
    fun provideGetArtisUseCase(artistsRepository: ArtistsRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistsRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateArtistUseCase(artistsRepository: ArtistsRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase((artistsRepository))
    }

    @Provides
    @Singleton
    fun provideGetTvShows(tvShowsReposytory: TvShowsReposytory): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowsReposytory)
    }

    @Provides
    @Singleton
    fun provideUpdateTvShowsUsecase(tvShowsReposytory: TvShowsReposytory): UpdateTvShows {
        return UpdateTvShows(tvShowsReposytory)
    }

}