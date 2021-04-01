package com.example.albumsmvvm.activities

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.albumsmvvm.viewmodel.AlbumViewModel
import com.example.albumsmvvm.viewmodel.ViewModelFactory

open class BaseActivity : AppCompatActivity() {

    val viewModel: AlbumViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(AlbumViewModel::class.java)
    }
}