package com.example.albumsmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.albumsmvvm.api.AlbumApi
import com.example.albumsmvvm.api.RetrofitInitializer
import com.example.albumsmvvm.repository.AlbumRepository

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    private fun api() = AlbumApi(RetrofitInitializer().create())
    private fun repository() = AlbumRepository(api())

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = AlbumViewModel(repository()) as T
}