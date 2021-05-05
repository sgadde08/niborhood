package com.homework.niborhood.network

import com.homework.niborhood.network.model.PositionModel
import com.homework.niborhood.network.retrofit.PortfolioEndpoint
import com.homework.niborhood.network.retrofit.RetrofitRequest

object StocksRepository {

    private var apiRequest: PortfolioEndpoint? = null

    init {
        apiRequest = RetrofitRequest.retrofitInstance?.create(PortfolioEndpoint::class.java)
    }

    suspend fun getStocks(): List<PositionModel> {
        return apiRequest?.getPortfolio()?.results.orEmpty()
    }
}