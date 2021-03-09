package com.ctt.followthebitcoins.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Ticker(
    @SerializedName("high")
    val highestPrice: Double,
    @SerializedName("low")
    val lowestPrice: Double,
    @SerializedName("vol")
    val volumeTraded: Double,
    @SerializedName("last")
    val lastPrice: Double,
    @SerializedName("buy")
    val highestPriceBought: Double,
    @SerializedName("sell")
    val highestPriceSold: Double,
    @SerializedName("date")
    val date: Date,
)