package com.devpro.android58_day10.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.devpro.android58_day10.R

object MyBindingAdapter {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(imageView: ImageView, url: String? = null) {
        if (url.isNullOrEmpty()) {
            imageView.setImageResource(R.drawable.ic_launcher_background)
            return
        }

        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }
}
