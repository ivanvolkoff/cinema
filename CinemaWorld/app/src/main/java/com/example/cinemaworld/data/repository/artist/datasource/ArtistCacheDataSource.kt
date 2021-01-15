package com.example.cinemaworld.data.repository.artist.datasource

import com.example.cinemaworld.data.model.artist.Artist
import com.example.cinemaworld.data.model.movie.Movie

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache(): List<Artist>

    suspend fun saveArtistToCache(artists: List<Artist>)
}