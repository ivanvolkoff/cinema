package com.example.cinemaworld.data.db

import androidx.room.*
import com.example.cinemaworld.data.model.artist.Artist

@Dao
interface ArtistsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artist: List<Artist>)

    @Query("DELETE FROM popular_artist")
    suspend fun deleteAllArtists()

    @Query("SELECT * FROM popular_artist")
    suspend fun getArtist(): List<Artist>
}