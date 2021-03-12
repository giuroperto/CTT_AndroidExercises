package com.ctt.followthebitcoins.services

import com.ctt.followthebitcoins.model.OrderBook
import com.ctt.followthebitcoins.model.TickerResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface OrderBookService {
    @GET("{coin}/orderbook/")

    fun getOrderBook(
            @Path("coin")
            coin: String
    ) : Call<OrderBook>
}