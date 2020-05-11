package com.github.jaydeepw.imagery.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.jaydeepw.imagery.R
import com.github.jaydeepw.imagery.adapters.MainAdapter
import com.github.jaydeepw.imagery.models.AdapterItem
import com.github.jaydeepw.imagery.utils.getRandomDogPhotos
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    var mainVerticalAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val photos = getRandomDogPhotos(4)

        val adapterItem1 = AdapterItem("Dogs", photos)
        val adapterItem2 = AdapterItem("Yak", photos)
        val adapterItem3 = AdapterItem("Sheep", photos)
        val adapterItem4 = AdapterItem("Dear", photos)
        val adapterItems = arrayListOf(
            adapterItem1, adapterItem2,
            adapterItem3, adapterItem4
        )

        mainVerticalAdapter = MainAdapter(requireContext(), adapterItems as ArrayList<Any>)

        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerViewMaster.layoutManager = layoutManager
        recyclerViewMaster.adapter = mainVerticalAdapter
        recyclerViewMaster.setDivider(R.drawable.recycler_view_divider)
    }

    fun RecyclerView.setDivider(@DrawableRes drawableRes: Int) {
        val divider = DividerItemDecoration(
            this.context,
            DividerItemDecoration.VERTICAL
        )
        val drawable = ContextCompat.getDrawable(
            this.context,
            drawableRes
        )
        drawable?.let {
            divider.setDrawable(it)
            addItemDecoration(divider)
        }
    }

}
