package com.example.cinemaworld.data.repository.artist.datasource

import com.example.cinemaworld.data.model.artist.ArtistsList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistsList>
}