package com.example.vodaaccounttask.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class Account(
    val name: String?,
    val msisdn: String,
    val icon: String,
    var isDefault: Boolean = false
) {
    companion object {
        @JvmStatic
        @BindingAdapter("android:loadImage")
        fun loadImage(imageView: ImageView, url: String) {
            Glide.with(imageView)
                .load(url)
                .transform(RoundedCorners(imageView.maxWidth/2))
                .into(imageView)
        }
    }
}
