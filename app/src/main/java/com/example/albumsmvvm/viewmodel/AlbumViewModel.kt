package com.example.albumsmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.albumsmvvm.model.PhotoAlbumEntity
import com.example.albumsmvvm.model.AlbumEntity
import com.example.albumsmvvm.model.RequestState
import com.example.albumsmvvm.repository.AlbumRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class AlbumViewModel(private val repository: AlbumRepository): ViewModel() {

    val albumList = MutableLiveData<RequestState<List<AlbumEntity>>>()
    val photosAlbum = MutableLiveData<RequestState<List<PhotoAlbumEntity>>>()

    fun getList() {
        viewModelScope.launch {
            try {
                albumList.value = RequestState.Success(repository.getList())

            } catch (e: Exception) {
                albumList.value = RequestState.Error(Throwable("Erro ao efetuar a busca dos albums"))
            }
        }
    }

    fun getPhotos(idAlbum: Int) {
        viewModelScope.launch {
            photosAlbum.value = RequestState.Success(repository.getPhotos(idAlbum))
        }
    }
}