package com.example.cinemaworld.data.repository.tvShows

import android.util.Log
import com.example.cinemaworld.data.model.tvShow.TvShow
import com.example.cinemaworld.data.repository.tvShows.datasource.TvShowsCacheDataSource
import com.example.cinemaworld.data.repository.tvShows.datasource.TvShowsLocalDatasource
import com.example.cinemaworld.data.repository.tvShows.datasource.TvShowsRemoteDatasource
import com.example.cinemaworld.domain.repository.TvShowsReposytory

class TvShowRepositoryImpl(
    private val tvShowsRemoteDatasource: TvShowsRemoteDatasource,
    private val tvShowsLocalDataSource: TvShowsLocalDatasource,
    private val tvShowsCacheDataSource: TvShowsCacheDataSource
) : TvShowsReposytory {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromApi()
        tvShowsLocalDataSource.clearAll()
        tvShowsLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowsCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromApi(): List<TvShow> {
        lateinit var tvShowsList: List<TvShow>

        try {
            val respone = tvShowsRemoteDatasource.getTvShows()
            val body = respone.body()
            if (body != null) {
                tvShowsList = body.tvShows
            }
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        return tvShowsList

    }

    suspend fun getTvShowsFromDB(): List<TvShow> {
        lateinit var tvShowsList: List<TvShow>

        try {
            tvShowsList = tvShowsLocalDataSource.getTvShowsFromDB()

        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }
        if (tvShowsList.isNotEmpty()) {
            return tvShowsList
        } else {
            tvShowsList = getTvShowsFromApi()
            tvShowsLocalDataSource.saveTvShowsToDB(tvShowsList)
        }

        return tvShowsList
    }

    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShowsList: List<TvShow>

        try {
            tvShowsList = tvShowsCacheDataSource.getTvShowsFromCache()

        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }
        if (tvShowsList.isNotEmpty()) {
            return tvShowsList
        } else {
            tvShowsList = getTvShowsFromDB()
            tvShowsCacheDataSource.saveTvShowsToCache(tvShowsList)
        }

        return tvShowsList
    }
}