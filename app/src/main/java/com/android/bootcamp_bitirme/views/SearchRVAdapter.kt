package com.android.bootcamp_bitirme.views

import android.annotation.SuppressLint
import com.android.bootcamp_bitirme.models.ItunesResult
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.bootcamp_bitirme.R
import com.android.bootcamp_bitirme.databinding.ItemSearchResultBinding
import com.android.bootcamp_bitirme.models.MusicData
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.RequestOptions.fitCenterTransform
import kotlinx.android.synthetic.main.item_search_result.view.*

class SearchRVAdapter() : RecyclerView.Adapter<SearchRVAdapter.SearchViewHolder>() {
    private lateinit var binding :ItemSearchResultBinding
    private var result:List<MusicData> = emptyList<MusicData>()

    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_search_result, parent, false)
        binding = ItemSearchResultBinding.bind(view.rootView)
        return SearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        binding.item
        Glide.with(binding.itemImage)
            .asBitmap()
            .fitCenter()
            .load(result[position].artworkUrl100)
            .into(holder.itemView.itemImage)

    }

    override fun getItemCount(): Int = result.size

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setData(result: List<MusicData>){
        this.result= result
        notifyDataSetChanged()
    }

}