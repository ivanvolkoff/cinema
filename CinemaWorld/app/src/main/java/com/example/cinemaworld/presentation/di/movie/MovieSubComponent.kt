package com.example.cinemaworld.presentation.di.movie

import com.example.cinemaworld.presentation.artists.ArtistsActivity
import com.example.cinemaworld.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }
}