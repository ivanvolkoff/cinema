package com.example.cinemaworld.data.repository.artist.datasource

import com.example.cinemaworld.data.model.artist.Artist
import com.example.cinemaworld.data.model.movie.Movie

interface ArtistLocalDataSource {
    suspend fun getArtistFromDB(): List<Artist>
    suspend fun saveArtistToDB(artists:List<Artist>)
    suspend fun clearAll()

}