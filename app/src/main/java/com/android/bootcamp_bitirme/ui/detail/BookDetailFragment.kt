package com.android.bootcamp_bitirme.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.android.bootcamp_bitirme.R
import com.android.bootcamp_bitirme.databinding.FragmentDetailBookBinding

class BookDetailFragment : Fragment(R.layout.fragment_detail_book){
    private val args:BookDetailFragmentArgs by navArgs()
    private val binding: FragmentDetailBookBinding by lazy {
        FragmentDetailBookBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.item = args.data
        return binding.root
    }
}