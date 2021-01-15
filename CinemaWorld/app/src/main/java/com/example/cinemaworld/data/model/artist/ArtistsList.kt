package com.example.cinemaworld.data.model.artist

import com.google.gson.annotations.SerializedName

data class ArtistsList(
    @SerializedName("artists")
    val artists: List<Artist>,

    )