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
import com.example.albumsmvvm.util.OnAlbumSelectListener

class MainActivity : BaseActivity(), OnAlbumSelectListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configList()

        supportActionBar?.title = "Album"

        viewModel.albumList.observe(this, Observer {
            when (it) {
                is RequestState.Success -> {
                    hideLoading()
                    loadList(it.data)
                }
                is RequestState.Loading -> showLoading()
                is RequestState.Error   -> {
                    hideLoading()
                    showAlert(it.throwable.message)
                }
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

    private fun loadList(list: List<AlbumEntity>) {
        val rvAlbums = findViewById<RecyclerView>(R.id.rv_albums)
        val adapter = ListAlbumAdapter(list, this)
        rvAlbums.adapter = adapter
    }

    override fun onItemClick(item: AlbumEntity) {
        val bundle = Bundle()
        bundle.putInt("id_album", item.id)
        val intent = Intent(Intent(this, ListPhotosAlbumActivity::class.java))
        intent.putExtras(bundle)
        startActivity(intent)
    }
}