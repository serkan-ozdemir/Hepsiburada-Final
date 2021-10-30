package com.android.bootcamp_bitirme.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.android.bootcamp_bitirme.R
import com.android.bootcamp_bitirme.databinding.FragmentSearchBinding
import com.android.bootcamp_bitirme.models.repository.Repository


//TODO result types & name change rv_item
class SearchFragment : Fragment() {
    private lateinit var searchPageVM: SearchViewModel
    private val binding: FragmentSearchBinding by lazy {
        FragmentSearchBinding.inflate(
            layoutInflater
        )
    }
    private val searchAdapter = SearchRVAdapter()
    private val repository = Repository()
    private var searchText = ""
    private var offsetCount = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        searchPageVM = SearchViewModel(repository)
        setupRecyclerView()
        return binding.root
    }
    //Initialize listeners and observe
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(view)
        searchBarInitializer()
        radioGroupInitializer()
    }
    //live data observe and change adapter's data
    private fun observe(view:View){
        searchPageVM.resultList.observe(viewLifecycleOwner, {
            if (it.isSuccessful) {
                searchAdapter.setData(it.body()!!.results.toMutableList(), offsetCount)
            } else {
                Log.d("Retrofit", "Error ${it.errorBody()}")
                Toast.makeText(view.context,"${it.errorBody()}",Toast.LENGTH_SHORT).show()
            }
        })
    }
    //Pagination with scrolling
    private fun setupRecyclerView() {
        binding.searchRV.adapter = searchAdapter
        binding.searchRV.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    offsetCount = binding.searchRV.adapter?.itemCount!!
                    searchPageVM.getAll(selectedButton(), searchText, offsetCount.toString())
                }
            }
        })
    }
    //search bar
    private fun searchBarInitializer() {
        binding.searchBar.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                if (p0?.length!! >= 2) {
                    offsetCount = 0
                    searchPageVM.getAll(selectedButton(), p0, offsetCount.toString())
                }
                return false
            }
            override fun onQueryTextChange(p0: String?): Boolean {
                searchText = if (p0?.length!! >= 2) {
                    offsetCount = 0
                    searchPageVM.getAll(selectedButton(), p0, offsetCount.toString())
                    p0
                } else {
                    searchAdapter.setData(mutableListOf(), 0)
                    ""
                }
                return false
            }
        })
    }
    //changing category get new data
    private fun radioGroupInitializer() {
        binding.categoryButtonGroup.setOnCheckedChangeListener { group, checkId ->
            offsetCount = 0
            searchPageVM.getAll(selectedButton(), searchText, offsetCount.toString())
        }
    }
    //set category name
    fun selectedButton(): String {
        when (binding.categoryButtonGroup.checkedRadioButtonId) {
            R.id.category_movie -> return "movie"
            R.id.category_music -> return "music"
            R.id.category_apps -> return "software"
            R.id.category_books -> return "ebook"
        }
        return ""
    }
}