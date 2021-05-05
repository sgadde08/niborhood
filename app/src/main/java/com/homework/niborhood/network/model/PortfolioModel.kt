package com.homework.niborhood.network.model

import com.google.gson.annotations.SerializedName

data class PortfolioModel(
    @SerializedName("stocks") val results: List<PositionModel>
)
