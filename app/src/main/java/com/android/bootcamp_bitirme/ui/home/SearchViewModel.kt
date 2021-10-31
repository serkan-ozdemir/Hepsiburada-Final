package com.android.bootcamp_bitirme.ui.home

import com.android.bootcamp_bitirme.models.ItunesResult
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.bootcamp_bitirme.models.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class SearchViewModel(private val repository: Repository) : ViewModel() {
    private val _resultList = MutableLiveData<Response<ItunesResult>>()
    val resultList: LiveData<Response<ItunesResult>> = _resultList
    //get data
    fun getAll(mediaName:String,searchText:String,offsetLimit:String){
        viewModelScope.launch{
            val response = repository.getAll(mediaName, searchText, offsetLimit)
            _resultList.value=response
        }
    }
}