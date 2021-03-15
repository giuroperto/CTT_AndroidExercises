package com.ctt.followthebitcoins.repository.services

import com.ctt.followthebitcoins.model.TickerResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TickerService {

    @GET("{coin}/ticker/")
    fun getTicker(
        @Path("coin")
        coin: String
    ) : Call<TickerResponse>
}

