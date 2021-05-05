package com.homework.niborhood.network.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class PositionModel(
    val ticker: String,
    val name: String,
    val currency: String,
    @SerializedName("current_price_cents") val currentPrice: BigDecimal,
    val quantity: Int,
    @SerializedName("current_price_timestamp") val timestamp: Long
)
