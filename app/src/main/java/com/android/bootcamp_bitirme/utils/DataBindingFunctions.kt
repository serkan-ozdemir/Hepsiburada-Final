package com.android.bootcamp_bitirme.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.fromHtml
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
                this.text=("$ $value")
            }else{
                this.text="Free"
            }
        }

        @BindingAdapter("formatTime")
        @JvmStatic
        fun TextView.formatTime(value: Long) {
            val sec = value/1000%60
            val min = value/(60*1000)%60
            val hour = value/(60*60*1000)%24
            if(hour.toInt()==0)
                this.text=String.format("%02d:%02d",min,sec)
            else
                this.text=String.format("%02d:%02d:%02d",hour,min,sec)
        }
        @BindingAdapter("cleanHtml")
        @JvmStatic
        fun TextView.cleanHtml(value: String) {
            this.text=fromHtml(value, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
        }
    }
}