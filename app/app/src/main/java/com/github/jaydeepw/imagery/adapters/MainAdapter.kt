package com.github.jaydeepw.imagery.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.jaydeepw.imagery.R
import com.github.jaydeepw.imagery.models.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_header.view.*
import kotlinx.android.synthetic.main.item_photo.view.*
import kotlinx.android.synthetic.main.item_recyclerview.view.*

class MainAdapter(val context: Context?, var items: ArrayList<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_DATA = 1
        const val TYPE_RECYCLER_VIEW = 2
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

            TYPE_RECYCLER_VIEW -> {
                val v: View =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_recyclerview, parent, false)
                return RecyclerViewHolder(v)
            }

            else -> {
                val v: View =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
                return HeaderViewHolder(v)
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PhotoViewHolder -> {
                val photo = items[position] as Photo
                val url = photo.url
                Log.d("Adapter", "url $url")
                Picasso.get().load(url)
                    .placeholder(android.R.drawable.ic_lock_idle_alarm)
                    .into(holder.itemView.imageViewPhoto)
            }
            is HeaderViewHolder -> {
                val heading = items[position] as String
                Log.d("Adapter", "heading $heading")
                holder.itemView.textViewHeader.text = heading
            }
            is RecyclerViewHolder -> {
                val list = items[position] as ArrayList<Any>
                Log.d("Adapter", "photos.list ${list.size}")
                val layoutManager = LinearLayoutManager(holder.itemView.context)
                layoutManager.orientation = LinearLayoutManager.HORIZONTAL
                holder.itemView.recyclerView.layoutManager = layoutManager
                holder.itemView.recyclerView.adapter = MainAdapter(holder.itemView.context, list)
            }
            else -> {
                val heading = "Invalid view to show"
                Log.e("Adapter", "heading $heading")
                holder.itemView.textViewHeader.text = heading
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is Photo -> TYPE_DATA
            is ArrayList<*> -> TYPE_RECYCLER_VIEW
            else -> TYPE_HEADER
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}