package com.example.cinemaworld.data.repository.tvShows.datasourceImpl

import com.example.cinemaworld.data.db.TvShowsDao
import com.example.cinemaworld.data.model.tvShow.TvShow
import com.example.cinemaworld.data.repository.tvShows.datasource.TvShowsLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowsLocalDataSourceImpl(val tvShowsDao: TvShowsDao) : TvShowsLocalDatasource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowsDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowsDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowsDao.deleteAllShows()
        }
    }
}