package com.example.albumsmvvm.activities

import com.example.albumsmvvm.model.AlbumEntity

interface OnSelectListener {

    fun onItemClick(item: AlbumEntity)
}