package com.example.albumsmvvm.activities

import com.example.albumsmvvm.model.PhotoAlbumEntity

interface OnPhotoSelectListener {

    fun onItemClick(item: PhotoAlbumEntity)
}