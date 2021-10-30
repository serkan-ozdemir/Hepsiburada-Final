package com.android.bootcamp_bitirme.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.android.bootcamp_bitirme.R
import com.android.bootcamp_bitirme.databinding.FragmentDetailMovieBinding
import com.android.bootcamp_bitirme.databinding.FragmentDetailMusicBinding

class MovieDetailFragment :Fragment(R.layout.fragment_detail_movie){
    private val args:MovieDetailFragmentArgs by navArgs()
    private val binding: FragmentDetailMovieBinding by lazy {
        FragmentDetailMovieBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.item = args.data
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}