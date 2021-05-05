package com.homework.niborhood.network.retrofit

import com.homework.niborhood.network.model.PortfolioModel
import retrofit2.Call
import retrofit2.http.GET

interface PortfolioEndpoint {
    @GET("/cash-homework/cash-stocks-api/portfolio.json")
    suspend fun getPortfolio(): PortfolioModel
}