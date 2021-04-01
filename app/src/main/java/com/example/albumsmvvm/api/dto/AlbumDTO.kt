package com.example.albumsmvvm.api.dto

import com.example.albumsmvvm.model.AlbumEntity

data class AlbumDTO(val id: Int, val userId: Int, val title: String) {

    fun toAlbumEntity() = AlbumEntity(
        id = id,
        userId = userId,
        title = title
    )
}