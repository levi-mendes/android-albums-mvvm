package com.example.albumsmvvm.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.albumsmvvm.R
import com.example.albumsmvvm.activities.OnPhotoSelectListener
import com.example.albumsmvvm.model.PhotoAlbumEntity

class ListPhotosAlbumAdapter(
        private val items: List<PhotoAlbumEntity>,
        private val listener: OnPhotoSelectListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class OriginalViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var tvId: TextView = v.findViewById<View>(R.id.tv_id) as TextView
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
            val photo = items[position]

            //val url = "${photo.thumbnailUrl}.png"
            val url = "https://via.placeholder.com/50.png/09f/fff%20C/O%20https://placeholder.com/#How_To_Set_Image_Size"
//            val url = "https://via.placeholder.com/20.png/8e973b"
//                    .replace("https", "http")

            //val url = "https://via.placeholder.com/300/09f/fff.png"//FUNCIONOU
            //val url = "via.placeholder.com/150.png/92bfbf"
            Log.e("url", url)

            Glide.with(holder.itemView.context)
                    .load(url)
                    .into(holder.ivThumbnail)

//            Glide.with(holder.itemView.context)
//                    .load("http://you-ps.ru/uploads/posts/2013-08/1376601606_1273.png")
//                    .error(R.mipmap.ic_launcher)
//                    .placeholder(R.mipmap.ic_launcher_round)
//                    .into(holder.ivThumbnail)

//            holder.tvId.text = photo.id.toString()
            holder.tvTitle.text = photo.title
            holder.itemView.setOnClickListener { listener.onItemClick(photo) }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}