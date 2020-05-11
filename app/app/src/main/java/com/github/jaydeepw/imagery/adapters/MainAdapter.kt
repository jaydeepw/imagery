package com.github.jaydeepw.imagery.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.jaydeepw.imagery.R
import com.github.jaydeepw.imagery.models.AdapterItem
import com.github.jaydeepw.imagery.models.Photo
import kotlinx.android.synthetic.main.item_header.view.*
import kotlinx.android.synthetic.main.item_recyclerview.view.*

class MainAdapter(val context: Context?, var items: ArrayList<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_MESSAGE_HEADER = 0
        const val TYPE_DATA = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TYPE_MESSAGE_HEADER -> {
                val v: View =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
                return HeaderViewHolder(v)
            }

            TYPE_DATA -> {
                val v: View =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_recyclerview, parent, false)
                return AdapterItemViewHolder(v)
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
            is AdapterItemViewHolder -> {
                // show heading
                val adapterItem = items[position] as AdapterItem
                val heading = adapterItem.heading
                Log.d("Adapter", "heading $heading")
                holder.itemView.textViewHeader2.text = heading

                // show photos list
                val list = adapterItem.list
                Log.d("Adapter", "photos.list ${list.size}")
                val layoutManager = LinearLayoutManager(holder.itemView.context)
                layoutManager.orientation = LinearLayoutManager.HORIZONTAL
                holder.itemView.recyclerView.layoutManager = layoutManager
                holder.itemView.recyclerView.adapter =
                    PhotosAdapter(holder.itemView.context, list as ArrayList<Photo>)
            }
            is HeaderViewHolder -> {
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
            is AdapterItem -> TYPE_DATA
            else -> TYPE_MESSAGE_HEADER
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class AdapterItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}