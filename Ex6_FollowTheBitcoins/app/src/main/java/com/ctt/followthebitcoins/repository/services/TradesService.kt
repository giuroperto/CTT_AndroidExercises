package com.ctt.followthebitcoins.repository.services

import com.ctt.followthebitcoins.model.Trade
import com.ctt.followthebitcoins.model.TradeList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TradesService {
    @GET("{coin}/trades/")

    fun getTrades(
            @Path("coin")
            coin: String
    ) : Call<TradeList>
}
