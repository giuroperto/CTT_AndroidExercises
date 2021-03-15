package com.ctt.followthebitcoins.repository.services

import com.ctt.followthebitcoins.model.OrderBook
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