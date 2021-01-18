package com.example.cinemaworld.presentation.di.tvshow

import com.example.cinemaworld.presentation.artists.ArtistsActivity
import com.example.cinemaworld.presentation.movie.MovieActivity
import com.example.cinemaworld.presentation.tvshows.TvShowActivity
import dagger.Subcomponent

@TvshowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }
}