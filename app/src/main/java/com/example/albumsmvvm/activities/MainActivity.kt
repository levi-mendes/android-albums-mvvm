package com.example.albumsmvvm.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.albumsmvvm.R
import com.example.albumsmvvm.adapter.ListAlbumAdapter
import com.example.albumsmvvm.model.AlbumEntity
import com.example.albumsmvvm.model.RequestState

class MainActivity : BaseActivity(), OnSelectListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configList()

        viewModel.albumList.observe(this, Observer {
            when (it) {
                is RequestState.Success -> {
                    hideLoading()
                    loadList(it.data)
                }
                is RequestState.Loading -> showLoading()
                is RequestState.Error   -> showError()
            }
        })

        viewModel.getList()
    }

    private fun configList() {
        val rvAlbums = findViewById<RecyclerView>(R.id.rv_albums)
        rvAlbums.layoutManager = LinearLayoutManager(this)
        rvAlbums.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        rvAlbums.setHasFixedSize(true)
    }

    private fun hideLoading() {
        findViewById<ProgressBar>(R.id.pb_loading).visibility = View.INVISIBLE
    }

    private fun showLoading() {
        findViewById<ProgressBar>(R.id.pb_loading).visibility = View.VISIBLE
    }

    private fun showError() {

    }

    private fun loadList(list: List<AlbumEntity>) {
        val rvAlbums = findViewById<RecyclerView>(R.id.rv_albums)
        val adapter = ListAlbumAdapter(list, this)
        rvAlbums.adapter = adapter
    }

    override fun onItemClick(item: AlbumEntity) {

        startActivity(Intent(this, ListPhotosAlbumActivity::class.java))
    }
}