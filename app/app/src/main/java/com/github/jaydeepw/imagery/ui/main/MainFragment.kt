package com.github.jaydeepw.imagery.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.jaydeepw.imagery.R
import com.github.jaydeepw.imagery.adapters.MainVerticalAdapter
import com.github.jaydeepw.imagery.models.Photo
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    var mainVerticalAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null
    val firstHorizontalAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null
    val secondHorizontalAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null
    val thirdHorizontalAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val list = arrayListOf(Photo("https://images.unsplash.com/photo-1489924034176-2e678c29d4c6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1651&q=80"),
            Photo("https://d1941uuft27pfg.cloudfront.net/breed-uploads/2018/08/siberian-husky-detail.jpg?bust=1535566590&width=630"))
        mainVerticalAdapter = MainVerticalAdapter(requireContext(), list as ArrayList<Any>)

        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerViewMaster.layoutManager = layoutManager
        recyclerViewMaster.adapter = mainVerticalAdapter
    }

}
