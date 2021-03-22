package com.ctt.followthebitcoins.repository.services

import com.ctt.followthebitcoins.model.Ticker

interface ApiResponse {
    fun tickerSuccess(ticker: Ticker)
}