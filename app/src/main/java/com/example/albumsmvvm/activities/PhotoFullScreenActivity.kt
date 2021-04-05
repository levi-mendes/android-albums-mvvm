package com.example.albumsmvvm.activities

import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.albumsmvvm.R

class PhotoFullScreenActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        setContentView(R.layout.activity_photo)

        supportActionBar?.hide()

        findViewById<ImageView>(R.id.iv_close).setOnClickListener { finish() }

        val url = intent.extras?.get("url") as String

        val ivPhoto = findViewById<ImageView>(R.id.iv_photo)
        Glide.with(this)
                .applyDefaultRequestOptions(requestOptions())
                .load("$url.PNG")
                .into(ivPhoto)
    }

    private fun requestOptions(): RequestOptions {
        return RequestOptions()
                .fitCenter()
                .placeholder(R.drawable.icon_loading_full)
                .error(R.drawable.icon_error_loading_full)
    }
}