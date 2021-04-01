package com.example.albumsmvvm.api.dto

data class AlbumDetailsDTO(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)