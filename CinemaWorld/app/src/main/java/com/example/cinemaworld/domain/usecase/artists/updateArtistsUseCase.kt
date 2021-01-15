package com.example.cinemaworld.domain.usecase.artists

import com.example.cinemaworld.data.model.artist.Artist
import com.example.cinemaworld.domain.repository.ArtistsRepository

class updateArtistsUseCase (private val artistsRepository: ArtistsRepository){
    suspend fun updateArtist():List<Artist>? = artistsRepository.updateArtists()
}