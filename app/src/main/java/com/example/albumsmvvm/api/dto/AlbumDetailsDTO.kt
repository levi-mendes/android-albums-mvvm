package com.example.albumsmvvm.api.dto

import com.example.albumsmvvm.model.AlbumDetailsEntity

data class AlbumDetailsDTO(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
) {

    fun toAlbumDetailsEntity() = AlbumDetailsEntity(
        albumId, id, title, url, thumbnailUrl
    )
}