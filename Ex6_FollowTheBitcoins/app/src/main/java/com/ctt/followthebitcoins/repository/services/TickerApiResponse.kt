package com.ctt.followthebitcoins.repository.services

import com.ctt.followthebitcoins.model.Ticker

interface TickerApiResponse {
    fun success(ticker: Ticker)

}