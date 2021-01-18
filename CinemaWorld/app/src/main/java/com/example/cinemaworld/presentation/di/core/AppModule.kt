package com.example.cinemaworld.presentation.di.core

import android.content.Context
import com.example.cinemaworld.presentation.di.artist.ArtistSubComponent
import com.example.cinemaworld.presentation.di.movie.MovieSubComponent
import com.example.cinemaworld.presentation.di.tvshow.TvShowSubComponent
import com.example.cinemaworld.presentation.tvshows.TvShowsViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class,ArtistSubComponent::class,TvShowSubComponent::class])
class AppModule(private val context: Context) {
   @Singleton
   @Provides
    fun provideApplicationContext(): Context{
        return context.applicationContext
    }
}