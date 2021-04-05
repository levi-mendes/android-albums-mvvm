package com.example.albumsmvvm.activities

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.albumsmvvm.R
import com.example.albumsmvvm.adapter.ListPhotosAlbumAdapter
import com.example.albumsmvvm.model.PhotoAlbumEntity
import com.example.albumsmvvm.model.RequestState

class ListPhotosAlbumActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_photos_album)

        configActionBar()
        configList()

        viewModel.photosAlbum.observe(this, Observer {
            when (it) {
                is RequestState.Success -> {
                    hideLoading()
                    loadList(it.data)
                }
                is RequestState.Loading -> showLoading()
                is RequestState.Error   -> showAlert(it.throwable.message)
            }
        })

        val idAlbum = intent.extras?.get("id_album") as Int
        viewModel.getPhotos(idAlbum)
    }

    private fun configActionBar() {
        supportActionBar?.title = "Photos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun configList() {
        val rvPhotos = findViewById<RecyclerView>(R.id.rv_photos)
        rvPhotos.layoutManager = LinearLayoutManager(this)
        rvPhotos.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        rvPhotos.setHasFixedSize(true)
    }

    private fun hideLoading() {
        findViewById<ProgressBar>(R.id.pb_loading).visibility = View.INVISIBLE
    }

    private fun showLoading() {
        findViewById<ProgressBar>(R.id.pb_loading).visibility = View.VISIBLE
    }

    private fun loadList(list: List<PhotoAlbumEntity>) {
        val rvAlbums = findViewById<RecyclerView>(R.id.rv_photos)
        val adapter = ListPhotosAlbumAdapter(list)
        rvAlbums.adapter = adapter
    }
}