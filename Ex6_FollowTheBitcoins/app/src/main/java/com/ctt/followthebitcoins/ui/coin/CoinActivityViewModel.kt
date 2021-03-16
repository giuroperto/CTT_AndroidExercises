package com.ctt.followthebitcoins.ui.coin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ctt.followthebitcoins.model.Order
import com.ctt.followthebitcoins.repository.CoinRepository

class CoinActivityViewModel(
    private val coinRepository: CoinRepository = CoinRepository()
) : ViewModel() {
    private lateinit var orderbookLiveData : MutableLiveData<MutableList<Order>>

    fun getOrderBook() : MutableLiveData<MutableList<Order>> {
        orderbookLiveData = coinRepository.getOrderbook()
        return orderbookLiveData
    }
}