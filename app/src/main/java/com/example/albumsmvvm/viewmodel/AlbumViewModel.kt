package com.example.albumsmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.albumsmvvm.model.AlbumEntity
import com.example.albumsmvvm.model.RequestState
import com.example.albumsmvvm.repository.AlbumRepository
import kotlinx.coroutines.launch

class AlbumViewModel(private val repository: AlbumRepository): ViewModel() {

    //TODO retornar como LiveData ao inves de MutableLiveData
    val albumList = MutableLiveData<RequestState<List<AlbumEntity>>>()

    init {
        viewModelScope.launch {
            albumList.value = RequestState.Success(repository.getList())
        }
    }
}