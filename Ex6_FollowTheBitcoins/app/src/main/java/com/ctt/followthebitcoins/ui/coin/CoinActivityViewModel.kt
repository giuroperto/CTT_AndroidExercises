package com.ctt.followthebitcoins.ui.coin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ctt.followthebitcoins.model.Order
import com.ctt.followthebitcoins.model.Ticker
import com.ctt.followthebitcoins.model.Trade
import com.ctt.followthebitcoins.repository.CoinRepository

class CoinActivityViewModel(
    private val coinRepository: CoinRepository = CoinRepository()
) : ViewModel() {
    private lateinit var orderbookLiveData : MutableLiveData<MutableList<Order>>
    private lateinit var tradesLiveData : MutableLiveData<MutableList<Trade>>
    private lateinit var tickerLiveData : MutableLiveData<Ticker>

    fun getTicker() :  MutableLiveData<Ticker> {
        tickerLiveData = coinRepository.getTicker()
        return tickerLiveData

    }fun getOrderBook() : MutableLiveData<MutableList<Order>> {
        orderbookLiveData = coinRepository.getOrderbook()
        return orderbookLiveData
    }

    fun getTrades() : MutableLiveData<MutableList<Trade>> {
        tradesLiveData = coinRepository.getTrades()
        return tradesLiveData
    }
}