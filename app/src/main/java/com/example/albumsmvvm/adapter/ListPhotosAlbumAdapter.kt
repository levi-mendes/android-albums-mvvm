package com.example.albumsmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.albumsmvvm.R
import com.example.albumsmvvm.activities.OnPhotoSelectListener
import com.example.albumsmvvm.model.AlbumDetailsEntity

class ListPhotosAlbumAdapter(
    private val items: List<AlbumDetailsEntity>,
    private val listener: OnPhotoSelectListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class OriginalViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var tvId: TextView = v.findViewById<View>(R.id.tv_id) as TextView
        var tvTitle: TextView = v.findViewById<View>(R.id.tv_title) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_photo_list, parent, false)

        return OriginalViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is OriginalViewHolder) {
            val view = holder
            val photo = items[position]
            view.tvId.text = photo.id.toString()
            view.tvTitle.text = photo.title

            //holder.itemView.setOnClickListener { listener.onItemClick(photo) }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}