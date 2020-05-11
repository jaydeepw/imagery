package com.github.jaydeepw.imagery.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.jaydeepw.imagery.R
import com.github.jaydeepw.imagery.models.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_photo.view.*

class MainVerticalAdapter(val context: Context?, var items: ArrayList<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PhotoViewHolder) {
            val photo = items[position] as Photo
            val url = photo.url
            Log.d("Adapter", "url $url")
            Picasso.get().load(url)
                .placeholder(android.R.drawable.ic_lock_idle_alarm)
                .into(holder.itemView.imageViewPhoto)
        } else {

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // var imageViewPhoto: TextView = itemView.findViewById(R.id.imageViewPhoto)
    }
}