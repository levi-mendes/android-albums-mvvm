package com.example.albumsmvvm.model

data class PhotoAlbumEntity(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)