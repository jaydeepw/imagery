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
import kotlinx.android.synthetic.main.item_header.view.*
import kotlinx.android.synthetic.main.item_photo.view.*

class MainVerticalAdapter(val context: Context?, var items: ArrayList<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_DATA = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TYPE_HEADER -> {
                val v: View =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
                return HeaderViewHolder(v)
            }

            TYPE_DATA -> {
                val v: View =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
                return PhotoViewHolder(v)
            }

            else -> {
                val v: View =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
                return HeaderViewHolder(v)
            }
        }

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
            val heading = items[position] as String
            Log.d("Adapter", "heading $heading")
            holder.itemView.textViewHeader.text = heading
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is Photo -> TYPE_DATA
            else -> TYPE_HEADER
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}