package com.android.bootcamp_bitirme.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.android.bootcamp_bitirme.R
import com.android.bootcamp_bitirme.databinding.FragmentDetailAppBinding
import com.android.bootcamp_bitirme.databinding.FragmentDetailMusicBinding

class AppDetailFragment:Fragment(R.layout.fragment_detail_app) {
    private val args:AppDetailFragmentArgs by navArgs()
    private val binding: FragmentDetailAppBinding by lazy {
        FragmentDetailAppBinding.inflate(
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