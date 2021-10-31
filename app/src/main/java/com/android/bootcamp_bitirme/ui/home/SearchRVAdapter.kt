package com.android.bootcamp_bitirme.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.android.bootcamp_bitirme.databinding.ItemSearchResultBinding
import com.android.bootcamp_bitirme.models.ItemData
import kotlinx.coroutines.GlobalScope


class SearchRVAdapter : RecyclerView.Adapter<SearchRVAdapter.SearchViewHolder>() {

    private var result: MutableList<ItemData> = mutableListOf()

    inner class SearchViewHolder(private val binding: ItemSearchResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemData) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = ItemSearchResultBinding.inflate(view)
        val viewHolder = SearchViewHolder(binding)
        itemClick(viewHolder, binding)
        return viewHolder
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(result[position])
    }

    private fun itemClick(holder: SearchViewHolder, binding: ItemSearchResultBinding) {
        holder.itemView.setOnClickListener {
            when (binding.item!!.kind) {
                "song" -> it.findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToMusicDetailFragment(result[holder.layoutPosition]))
                "feature-movie" -> it.findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToMovieDetailFragment(result[holder.layoutPosition]))
                "ebook" -> it.findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToBookDetailFragment(result[holder.layoutPosition]))
                "software" -> it.findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToAppDetailFragment(result[holder.layoutPosition]))
            }

        }
    }

    override fun getItemCount(): Int = result.size

    // getItemId & getItemViewType stabilize positions of items
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    //set new data or add data
    @SuppressLint("NotifyDataSetChanged")
    fun setData(result: MutableList<ItemData>, offsetCount: Int) {
        if (offsetCount > 0) {
            this.result.addAll(result)
            this.notifyItemRangeChanged(itemCount - offsetCount, offsetCount)
        } else {
            this.result.clear()
            this.result.addAll(result)
            this.notifyDataSetChanged()
        }
    }
}