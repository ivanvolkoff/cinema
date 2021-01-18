package com.example.cinemaworld.presentation.di.core

import com.example.cinemaworld.data.api.TMDBService
import com.example.cinemaworld.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.cinemaworld.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImp
import com.example.cinemaworld.data.repository.movies.datasource.MovieRemoteDatasource
import com.example.cinemaworld.data.repository.movies.datasourceImpl.MovieRemoteDataSourceImpl
import com.example.cinemaworld.data.repository.tvShows.datasource.TvShowsRemoteDatasource
import com.example.cinemaworld.data.repository.tvShows.datasourceImpl.TvShowsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideRemoteMovieDataSource(tmdbService: TMDBService):MovieRemoteDatasource {
      return MovieRemoteDataSourceImpl(tmdbService,apiKey)
    }

    @Singleton
    @Provides
    fun provideRemoteArtistDataSource(tmdbService: TMDBService):ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImp(tmdbService,apiKey)
    }

    @Singleton
    @Provides
    fun providesRemoteTvShowsDataSource(tmdbService: TMDBService):TvShowsRemoteDatasource {
        return TvShowsRemoteDataSourceImpl(tmdbService,apiKey)
    }
}