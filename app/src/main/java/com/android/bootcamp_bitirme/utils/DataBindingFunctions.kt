package com.android.bootcamp_bitirme.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*

class DataBindingFunctions {
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

        @BindingAdapter("dateFormat")
        @JvmStatic
        fun TextView.dateFormat(date: String) {
            this.text=SimpleDateFormat("dd.MM.yyyy",Locale("us")).format(SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss",Locale("us")).parse(date)!!)
        }

        @BindingAdapter("priceToString")
        @JvmStatic
        fun TextView.priceToString(value: Any) {
            if(value!=0.0){
                this.text="$ ${value}"
            }else{
                this.text="Free"
            }
        }
    }
}