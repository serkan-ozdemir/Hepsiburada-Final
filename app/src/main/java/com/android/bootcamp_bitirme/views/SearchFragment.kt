package com.android.bootcamp_bitirme.views

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.android.bootcamp_bitirme.viewModels.SearchViewModel
import com.android.bootcamp_bitirme.databinding.FragmentSearchBinding
import com.android.bootcamp_bitirme.models.ItunesResult
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
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        searchPageVM = SearchViewModel(repository)
        setupRecyclerView()

        binding.viewM = searchPageVM
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchPageVM.resultList.observe(viewLifecycleOwner, {
            if (it.isSuccessful) {
                searchAdapter.setData(it.body()!!.results)
            } else {
                Log.d("Observe", "Error")
            }
        })
        binding.searchBar.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                if (p0?.length!! >=2) {
                    searchPageVM.getAll("music", p0!!, "0")
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                if (p0?.length!! >=2) {
                    searchPageVM.getAll("music", p0!!.replace(' ','+'), "0")
                }
                return false
            }
        })

    }

    fun setupRecyclerView() {
        binding.searchDataRV.adapter = searchAdapter.also { it.setHasStableIds(true) }
        binding.searchDataRV.setHasFixedSize(true)
        binding.searchDataRV.isNestedScrollingEnabled = false
    }

}