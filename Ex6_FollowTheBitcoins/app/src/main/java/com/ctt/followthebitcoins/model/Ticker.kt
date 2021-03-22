package com.ctt.followthebitcoins.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class TickerResponse (
    val ticker: Ticker?
)

//data class Ticker (
//        val high: Double,
//        val low: Double,
//        val vol: Double,
//        val last: Double,
//        val buy: Double,
//        val sell: Double,
//        val date: Double,
//        )

data class Ticker(
    @SerializedName("high")
    val high: Double,
    @SerializedName("low")
    val low: Double,
    @SerializedName("vol")
    val vol: Double,
    @SerializedName("last")
    val last: Double,
    @SerializedName("buy")
    val buy: Double,
    @SerializedName("sell")
    val sell: Double,
    @SerializedName("date")
    val date: Double,
)

