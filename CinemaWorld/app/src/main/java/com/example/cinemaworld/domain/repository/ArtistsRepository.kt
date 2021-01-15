package com.example.cinemaworld.domain.repository

import com.example.cinemaworld.data.model.artist.Artist

interface ArtistsRepository {
    suspend fun getArtist():List<Artist>?
    suspend fun updateArtists(): List<Artist>
}