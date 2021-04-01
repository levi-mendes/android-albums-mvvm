package com.example.albumsmvvm.api.dto

import com.example.albumsmvvm.model.PhotoAlbumEntity

data class PhotoAlbumDTO(
        val albumId: Int,
        val id: Int,
        val title: String,
        val url: String,
        val thumbnailUrl: String
) {

    fun toPhotoAlbumEntity() = PhotoAlbumEntity(
            albumId, id, title, url, thumbnailUrl
    )
}