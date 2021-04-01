package com.example.albumsmvvm.api

import com.example.albumsmvvm.api.dto.AlbumDTO
import com.example.albumsmvvm.api.dto.PhotoAlbumDTO
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

class AlbumApi(retrofit: Retrofit) {

    private val service by lazy {
        retrofit.create(ChalangeService::class.java)
    }

    suspend fun list() = service.list()

    suspend fun photos(id: Int) = service.photos(id = id)

    interface ChalangeService {

        @GET("albums")
        suspend fun list(): MutableList<AlbumDTO>

        @GET("photos")
        suspend fun photos(@Query("albumId") id: Int): List<PhotoAlbumDTO>
    }
}