package com.example.albumsmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.albumsmvvm.R
import com.example.albumsmvvm.activities.OnAlbumSelectListener
import com.example.albumsmvvm.model.AlbumEntity

class ListAlbumAdapter(
    private val items: List<AlbumEntity>,
    private val listener: OnAlbumSelectListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class OriginalViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var tvTitle: TextView = v.findViewById<View>(R.id.tv_title) as TextView
        //var tvId: TextView = v.findViewById<View>(R.id.tv_id) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_album_list, parent, false)

        return OriginalViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is OriginalViewHolder) {
            val album = items[position]
            holder.tvTitle.text = album.title
            //holder.tvId.text = album.id.toString()
            holder.itemView.setOnClickListener { listener.onItemClick(album) }
        }
    }

    override fun getItemCount() = items.size
}