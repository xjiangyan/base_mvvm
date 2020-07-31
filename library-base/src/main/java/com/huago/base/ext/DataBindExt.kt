package com.huago.base.ext

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion


//DataBinding自定义属性
@BindingAdapter("url")
fun loadImage(imageView: ImageView, url: String) {
//    GlideApp.with(AppContext).load(url)
//        .placeholder(R.mipmap.ic_github)
//        .into(imageView)
}

