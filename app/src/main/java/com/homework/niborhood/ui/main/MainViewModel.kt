package com.homework.niborhood.ui.main

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.homework.niborhood.network.StocksRepository
import com.homework.niborhood.network.model.PositionModel
import kotlinx.coroutines.launch
import java.math.BigDecimal

class MainViewModel : ViewModel() {
    val data = MutableLiveData<List<PositionModel>>()
    val error = MutableLiveData<Boolean>()
    val calculatedVale = MediatorLiveData<BigDecimal>().apply {
        addSource(data) { list ->
            var portfolioValue : BigDecimal = BigDecimal.ZERO
            list.forEach {
                portfolioValue += it.currentPrice.multiply(it.quantity.toBigDecimal())
            }
            value = portfolioValue
        }
    }

    init {
        getResults()
    }

    fun getResults() {
        viewModelScope.launch {
            kotlin.runCatching {
                StocksRepository.getStocks()
            }.onSuccess {
                data.postValue(it)
            }.onFailure {
                error.postValue(true)
            }
        }
    }

}