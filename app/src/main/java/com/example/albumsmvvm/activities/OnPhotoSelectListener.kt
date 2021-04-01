package com.example.albumsmvvm.activities

import com.example.albumsmvvm.model.AlbumDetailsEntity

interface OnPhotoSelectListener {

    fun onItemClick(item: AlbumDetailsEntity)
}