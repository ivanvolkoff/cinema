package com.example.cinemaworld.presentation.di.core

import com.example.cinemaworld.presentation.di.artist.ArtistSubComponent
import com.example.cinemaworld.presentation.di.movie.MovieSubComponent
import com.example.cinemaworld.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DataBaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataSourceModule::class
])
interface AppComponent {

    fun movieSubComponent():MovieSubComponent.Factory
    fun tvShowSubComponent():TvShowSubComponent.Factory
    fun artistSubComponent():ArtistSubComponent.Factory

}