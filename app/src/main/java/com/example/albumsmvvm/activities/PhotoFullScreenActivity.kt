package com.example.albumsmvvm.activities

import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.albumsmvvm.R

class PhotoFullScreenActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        setContentView(R.layout.activity_photo)

        supportActionBar?.hide()

        findViewById<ImageView>(R.id.iv_close).setOnClickListener { finish() }

        val url = intent.extras?.get("url") as String
        Log.e("url", url)

        val ivPhoto = findViewById<ImageView>(R.id.iv_photo)
        Glide.with(this)
            .load(url) //passing your url to load image.
            .fitCenter()//this method help to fit image into center of your ImageView
            .into(ivPhoto)
    }
}