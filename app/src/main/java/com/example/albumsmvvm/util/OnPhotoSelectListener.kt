package com.example.albumsmvvm.util

import com.example.albumsmvvm.model.PhotoAlbumEntity

interface OnPhotoSelectListener {

    fun onItemClick(item: PhotoAlbumEntity)
}