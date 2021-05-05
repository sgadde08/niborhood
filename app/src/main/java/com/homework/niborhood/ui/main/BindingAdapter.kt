package com.homework.niborhood.ui.main

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.homework.niborhood.R
import java.math.BigDecimal

@BindingAdapter("setPrice")
fun setImageResource(view: TextView, value: BigDecimal) {
    val dollarPrice = value.divide(BigDecimal("100"))
    view.text = view.resources.getString(R.string.price, dollarPrice)
}
