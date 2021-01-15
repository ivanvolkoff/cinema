package com.example.cinemaworld.data.model.tvShow

import com.google.gson.annotations.SerializedName

data class TvShowsList(
    @SerializedName("tvShows")
    val tvShows: List<TvShow>,
    )