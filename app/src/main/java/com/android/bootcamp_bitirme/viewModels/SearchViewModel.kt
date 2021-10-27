package com.android.bootcamp_bitirme.viewModels

import com.android.bootcamp_bitirme.models.ItunesResult
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.bootcamp_bitirme.models.MusicData
import com.android.bootcamp_bitirme.models.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class SearchViewModel(private val repository: Repository) : ViewModel() {
    private val _resultList = MutableLiveData<Response<ItunesResult>>()
    val resultList: LiveData<Response<ItunesResult>> = _resultList

    fun getAll(entityName:String, attributeName:String,searchText:String,offsetLimit:String){
        viewModelScope.launch{
            val response = repository.getAll(entityName, attributeName, searchText, offsetLimit)
            _resultList.value=response
        }
    }

}