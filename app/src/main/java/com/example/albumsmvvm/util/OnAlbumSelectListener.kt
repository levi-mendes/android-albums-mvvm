package com.example.albumsmvvm.util

import com.example.albumsmvvm.model.AlbumEntity

interface OnAlbumSelectListener {

    fun onItemClick(item: AlbumEntity)
}