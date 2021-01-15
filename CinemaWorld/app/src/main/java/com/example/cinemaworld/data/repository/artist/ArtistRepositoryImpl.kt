package com.example.cinemaworld.data.repository.artist

import android.util.Log
import com.example.cinemaworld.data.model.artist.Artist
import com.example.cinemaworld.data.model.movie.Movie
import com.example.cinemaworld.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.cinemaworld.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.cinemaworld.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.cinemaworld.domain.repository.ArtistsRepository

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistsRepository {
    override suspend fun getArtist(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtist = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(newListOfArtist)
        artistCacheDataSource.saveArtistToCache(newListOfArtist)
        return newListOfArtist
    }

    suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDatasource.getArtists()
            val body = response.body()
            if(body!=null){
                artistList = body.artists
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB():List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(artistList.size>0){
            return artistList
        }else{
            artistList=getArtistsFromDB()
            artistLocalDataSource.saveArtistToDB(artistList)
        }

        return artistList
    }

    suspend fun getArtistsFromCache():List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList =artistCacheDataSource.getArtistFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(artistList.size>0){
            return artistList
        }else{
            artistList=getArtistsFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)
        }

        return artistList
    }







}