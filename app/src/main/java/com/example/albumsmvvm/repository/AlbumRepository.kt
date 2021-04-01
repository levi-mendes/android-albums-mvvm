package com.example.albumsmvvm.repository

import com.example.albumsmvvm.api.AlbumApi
import com.example.albumsmvvm.model.AlbumEntity

class AlbumRepository(
    private val api: AlbumApi
) {

    suspend fun getList(): List<AlbumEntity> {
        return api.list().map {
            it.toAlbumEntity()
        }
    }
}