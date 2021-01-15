package com.example.cinemaworld.data.repository.artist.datasourceImpl

import com.example.cinemaworld.data.model.artist.Artist
import com.example.cinemaworld.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl:ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistFromCache(): List<Artist> {
       return artistList
    }

    override suspend fun saveArtistToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}