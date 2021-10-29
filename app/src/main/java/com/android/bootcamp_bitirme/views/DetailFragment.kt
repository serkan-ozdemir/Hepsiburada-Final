package com.android.bootcamp_bitirme.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.android.bootcamp_bitirme.R
import com.android.bootcamp_bitirme.databinding.FragmentDetailBinding
import com.android.bootcamp_bitirme.models.ItemData
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_search_result.view.*

class DetailFragment : Fragment(R.layout.fragment_detail) {
    //fromHtml("instruction<br /><br />", HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
    val args: DetailFragmentArgs by navArgs()
    private val binding: FragmentDetailBinding by lazy {
        FragmentDetailBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.item = args.asdasdd
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        @BindingAdapter("loadImage")
        @JvmStatic
        fun ImageView.loadImage(url: String?) {
            if (!url.isNullOrEmpty()) {
                Glide.with(this.context)
                    .asBitmap()
                    .fitCenter()
                    .load(url)
                    .into(this)
            }
        }
    }
}