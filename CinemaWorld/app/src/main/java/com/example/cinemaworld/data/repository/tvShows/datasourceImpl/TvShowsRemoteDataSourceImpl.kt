package com.example.cinemaworld.data.repository.tvShows.datasourceImpl

import com.example.cinemaworld.data.api.TMDBService
import com.example.cinemaworld.data.model.movie.MovieList
import com.example.cinemaworld.data.model.tvShow.TvShow
import com.example.cinemaworld.data.model.tvShow.TvShowsList
import com.example.cinemaworld.data.repository.tvShows.datasource.TvShowsRemoteDatasource
import retrofit2.Response

class TvShowsRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowsRemoteDatasource {
    override suspend fun getTvShows(): Response<TvShowsList> = tmdbService.getPopularTvShows(apiKey)
}