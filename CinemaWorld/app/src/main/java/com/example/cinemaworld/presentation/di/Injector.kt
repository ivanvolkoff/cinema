package com.example.cinemaworld.presentation.di

import com.example.cinemaworld.presentation.di.artist.ArtistSubComponent
import com.example.cinemaworld.presentation.di.movie.MovieSubComponent
import com.example.cinemaworld.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent


}