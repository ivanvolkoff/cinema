package com.example.cinemaworld.presentation.di.core

import com.example.cinemaworld.data.db.ArtistsDao
import com.example.cinemaworld.data.db.MovieDao
import com.example.cinemaworld.data.db.TvShowsDao
import com.example.cinemaworld.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.cinemaworld.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.example.cinemaworld.data.repository.movies.datasource.MovieLocalDatasource
import com.example.cinemaworld.data.repository.movies.datasourceImpl.MovieLocalDataSourceImpl
import com.example.cinemaworld.data.repository.tvShows.datasource.TvShowsLocalDatasource
import com.example.cinemaworld.data.repository.tvShows.datasourceImpl.TvShowsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDatasource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistsDao: ArtistsDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistsDao)
    }

    @Singleton
    @Provides
    fun provideTvShowsLocalDataSource(tvShowsDao: TvShowsDao): TvShowsLocalDatasource {
        return TvShowsLocalDataSourceImpl(tvShowsDao)
    }
}