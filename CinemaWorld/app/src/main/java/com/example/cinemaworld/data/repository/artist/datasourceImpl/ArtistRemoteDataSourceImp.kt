package com.example.cinemaworld.data.repository.artist.datasourceImpl

import com.example.cinemaworld.data.api.TMDBService
import com.example.cinemaworld.data.model.artist.ArtistsList
import com.example.cinemaworld.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImp(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistsList> {
        return tmdbService.getPopularArtists(apiKey)
    }
}