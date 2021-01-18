package com.example.cinemaworld.presentation.di.core

import com.example.cinemaworld.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.cinemaworld.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.example.cinemaworld.data.repository.movies.datasource.MovieCacheDataSource
import com.example.cinemaworld.data.repository.movies.datasourceImpl.MovieCahceDataSourceImpl
import com.example.cinemaworld.data.repository.tvShows.datasource.TvShowsCacheDataSource
import com.example.cinemaworld.data.repository.tvShows.datasourceImpl.TvShowsCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataSourceModule {
    @Singleton
    @Provides
    fun provideMovieCahceDataSource(): MovieCacheDataSource {
        return MovieCahceDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCahceDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowsCahceDataSource(): TvShowsCacheDataSource {
        return TvShowsCacheDataSourceImpl()
    }
}