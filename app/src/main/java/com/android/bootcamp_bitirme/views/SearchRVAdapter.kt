package com.android.bootcamp_bitirme.views

import android.annotation.SuppressLint
import android.util.Log
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*


class SearchRVAdapter() : RecyclerView.Adapter<SearchRVAdapter.SearchViewHolder>() {

    private var result: MutableList<ItemData> = mutableListOf<ItemData>()

    inner class SearchViewHolder(private val binding: ItemSearchResultBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: ItemData) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = ItemSearchResultBinding.inflate(view)
        val viewHolder = SearchViewHolder(binding)

        itemClick(viewHolder)
        return viewHolder
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(result[position])
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
            this.notifyItemRangeChanged(itemCount-offsetCount,offsetCount)
        } else {
            this.result.clear()
            this.result.addAll(result)
            this.notifyDataSetChanged()
        }

    }

}