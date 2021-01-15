package com.example.cinemaworld.data.repository.artist.datasourceImpl

import com.example.cinemaworld.data.db.ArtistsDao
import com.example.cinemaworld.data.model.artist.Artist
import com.example.cinemaworld.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistsDao: ArtistsDao): ArtistLocalDataSource {
    override suspend fun getArtistFromDB(): List<Artist> {
        return artistsDao.getArtist()
    }

    override suspend fun saveArtistToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistsDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {

    }


}