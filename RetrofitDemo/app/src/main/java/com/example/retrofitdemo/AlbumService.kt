package com.example.retrofitdemo

import retrofit2.Response
import retrofit2.http.*

interface AlbumService {
    //all albums
    @GET("/albums")
    suspend fun getAlbums(): Response<Album>

    //albums where id is 3 added query parameter for
    @GET("/albums")
    suspend fun getAlbumsForUserID(@Query("userId") userId: Int): Response<Album>

    @GET("/albums/{id}")
    suspend fun getAlbum(@Path(value = "id") albumId: Int): Response<AlbumItem>

    @POST("albums")
    suspend fun uploadAlbub(@Body album: AlbumItem): Response<AlbumItem>


}