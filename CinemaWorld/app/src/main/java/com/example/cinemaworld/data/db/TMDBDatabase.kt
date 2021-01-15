package com.example.cinemaworld.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cinemaworld.data.model.artist.Artist
import com.example.cinemaworld.data.model.movie.Movie
import com.example.cinemaworld.data.model.tvShow.TvShow

@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1, exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    abstract fun tvDao(): TvShowsDao

    abstract fun artistsDao(): ArtistsDao
}