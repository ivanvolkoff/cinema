package com.example.cinemaworld.data.model.movie

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "popular_movie")
data class Movie(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_language")
    val original_language: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("release_date")
    val release_date: String,
    @SerializedName("title")
    val title: String,
)