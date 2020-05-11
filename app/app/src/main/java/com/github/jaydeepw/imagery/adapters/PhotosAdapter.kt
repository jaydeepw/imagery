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

class PhotosAdapter(val context: Context?, var items: ArrayList<Photo>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_DATA = 1
        const val TYPE_MSG_VIEW = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_DATA -> {
                val v: View =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
                AdapterItemViewHolder(v)
            }

            else -> {
                val v: View =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
                MessageViewHolder(v)
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is AdapterItemViewHolder -> {
                val photo = items[position]
                val url = photo.url
                Log.d("Adapter", "photo.url ${url}")
                // holder.itemView.textViewHeader2.text = heading
                Picasso.get().load(url)
                    .placeholder(android.R.drawable.ic_lock_idle_alarm)
                    .into(holder.itemView.imageViewPhoto)

                /*val list = items[position] as ArrayList<Any>
                Log.d("Adapter", "photos.list ${list.size}")
                val layoutManager = LinearLayoutManager(holder.itemView.context)
                layoutManager.orientation = LinearLayoutManager.HORIZONTAL
                holder.itemView.recyclerView.layoutManager = layoutManager
                holder.itemView.recyclerView.adapter = PhotosAdapter(holder.itemView.context, list)*/
            }
            is MessageViewHolder -> {
                val heading = items[position] as String
                Log.d("Adapter", "heading $heading")
                holder.itemView.textViewHeader.text = heading
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
            else -> TYPE_MSG_VIEW
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class AdapterItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}