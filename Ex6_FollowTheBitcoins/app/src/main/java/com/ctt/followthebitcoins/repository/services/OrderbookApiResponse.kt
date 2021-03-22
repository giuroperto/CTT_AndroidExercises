package com.ctt.followthebitcoins.repository.services

import com.ctt.followthebitcoins.model.OrderBook

interface OrderbookApiResponse {
    fun success(orderbook: OrderBook)
//    fun tradesSuccess(trades: OrderBook)
}