package com.example.albumsmvvm.adapter

import android.content.Intent
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.albumsmvvm.R
import com.example.albumsmvvm.util.OnPhotoSelectListener
import com.example.albumsmvvm.activities.PhotoFullScreenActivity
import com.example.albumsmvvm.model.PhotoAlbumEntity

class ListPhotosAlbumAdapter(
        private val items: List<PhotoAlbumEntity>,
        private val listener: OnPhotoSelectListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class OriginalViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        //var tvId: TextView = v.findViewById<View>(R.id.tv_id) as TextView
        var tvTitle: TextView = v.findViewById<View>(R.id.tv_title) as TextView
        var ivThumbnail: ImageView = v.findViewById(R.id.iv_thumbnail) as ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_photo_list, parent, false)

        return OriginalViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is OriginalViewHolder) {
            val context = holder.itemView.context
            val photo = items[position]

            val url = photo.thumbnailUrl + ".PNG"
            Log.e("url", url)

            val placeholder = BitmapFactory.decodeResource(context.resources, R.drawable.icon_loading)
            val circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.resources, placeholder)
            circularBitmapDrawable.isCircular = true

            Glide.with(holder.itemView.context)
                    .applyDefaultRequestOptions(requestOptions())
                    .load(url)
                    .apply(RequestOptions.circleCropTransform())
                    .into(holder.ivThumbnail)

            holder.ivThumbnail.setOnClickListener {
                val intent = Intent(context, PhotoFullScreenActivity::class.java)
                intent.putExtra("url", photo.url)
                context.startActivity(intent)
            }

            holder.tvTitle.text = photo.title
            holder.itemView.setOnClickListener { listener.onItemClick(photo) }
        }
    }

    private fun requestOptions(): RequestOptions {
        return RequestOptions()
                .circleCrop()
                .placeholder(R.drawable.icon_loading)
                .error(R.drawable.icon_error_loading)
                .circleCrop()
    }

    override fun getItemCount() = items.size
}