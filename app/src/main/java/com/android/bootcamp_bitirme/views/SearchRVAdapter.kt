package com.android.bootcamp_bitirme.views

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.android.bootcamp_bitirme.R
import com.android.bootcamp_bitirme.databinding.ItemSearchResultBinding
import com.android.bootcamp_bitirme.models.ItemData
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_search_result.view.*
import java.text.SimpleDateFormat
import java.util.*


class SearchRVAdapter() : RecyclerView.Adapter<SearchRVAdapter.SearchViewHolder>() {
    private lateinit var binding: ItemSearchResultBinding
    private var result: MutableList<ItemData> = mutableListOf<ItemData>()

    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_search_result, parent, false)
        binding = ItemSearchResultBinding.bind(view.rootView)
        val viewHolder = SearchViewHolder(view)

        itemClick(viewHolder)
        return viewHolder
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.itemView.collectionName.text = result[position].collectionName
        holder.itemView.collectionPrice.text =
            if (result[position].collectionPrice > 0) result[position].collectionPrice.toString() else "Free"
        holder.itemView.releaseDate.text = SimpleDateFormat(
            "dd.MM.yyyy",
            Locale("us")
        ).format(SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(result[position].releaseDate))

        Glide.with(binding.itemImage)
            .asBitmap()
            .fitCenter()
            .load(result[position].artworkUrl100)
            .into(holder.itemView.itemImage)
    }

    private fun itemClick(holder: SearchViewHolder) {
        holder.itemView.setOnClickListener {
            it.findNavController().navigate(SearchFragmentDirections.actionSearchFragment2ToDetailFragment(result[holder.layoutPosition]))
        }
    }

    override fun getItemCount(): Int = result.size

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(result: MutableList<ItemData>, offsetCount: Int) {
        if (offsetCount > 0) {
            this.result.addAll(result)
        } else {
            this.result = result
        }
        notifyDataSetChanged()
    }

}