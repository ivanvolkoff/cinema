package com.example.cinemaworld.presentation.di.core

import com.example.cinemaworld.data.repository.artist.ArtistRepositoryImpl
import com.example.cinemaworld.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.cinemaworld.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.cinemaworld.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.cinemaworld.data.repository.movies.MovieRepositoryImpl
import com.example.cinemaworld.data.repository.movies.datasource.MovieCacheDataSource
import com.example.cinemaworld.data.repository.movies.datasource.MovieLocalDatasource
import com.example.cinemaworld.data.repository.movies.datasource.MovieRemoteDatasource
import com.example.cinemaworld.data.repository.tvShows.TvShowRepositoryImpl
import com.example.cinemaworld.data.repository.tvShows.datasource.TvShowsCacheDataSource
import com.example.cinemaworld.data.repository.tvShows.datasource.TvShowsLocalDatasource
import com.example.cinemaworld.data.repository.tvShows.datasource.TvShowsRemoteDatasource
import com.example.cinemaworld.domain.repository.ArtistsRepository
import com.example.cinemaworld.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieCacheDataSource: MovieCacheDataSource,
        movieLocalDatasource: MovieLocalDatasource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDatasource,
            movieCacheDataSource
        )

    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistCacheDataSource: ArtistCacheDataSource,
        artistLocalDataSource: ArtistLocalDataSource
    ): ArtistsRepository {

        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )

    }

    @Singleton
    @Provides
    fun providesTvShowsRepository(
        tvShowsCacheDataSource: TvShowsCacheDataSource,
        tvShowsLocalDatasource: TvShowsLocalDatasource,
        tvShowsRemoteDatasource: TvShowsRemoteDatasource
    ): TvShowRepositoryImpl {

        return TvShowRepositoryImpl(
            tvShowsRemoteDatasource,
            tvShowsLocalDatasource,
            tvShowsCacheDataSource
        )
    }
}