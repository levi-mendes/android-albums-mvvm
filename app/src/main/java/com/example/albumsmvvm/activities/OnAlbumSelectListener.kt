package com.example.albumsmvvm.activities

import com.example.albumsmvvm.model.AlbumEntity

interface OnAlbumSelectListener {

    fun onItemClick(item: AlbumEntity)
}