package com.example.albumsmvvm.activities

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.albumsmvvm.R

class ListPhotosAlbumActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_photos_album)

        //TODO titulo "Fotos"

        viewModel.albumDetails.observe(this, Observer {
            
        })
    }
}