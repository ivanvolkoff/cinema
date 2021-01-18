package com.example.cinemaworld.presentation.di.artist

import com.example.cinemaworld.domain.usecase.artists.GetArtistsUseCase
import com.example.cinemaworld.domain.usecase.artists.UpdateArtistsUseCase
import com.example.cinemaworld.presentation.artists.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactort(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }

}