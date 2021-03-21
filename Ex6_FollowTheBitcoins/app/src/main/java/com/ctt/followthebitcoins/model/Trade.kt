package com.ctt.followthebitcoins.model

data class Trade(
        val date: Double,
        val price: Double,
        val amount: Double,
        val tid: Int,
        val type: String
)

//data class TradeList(
//        val data: MutableList<Trade>
//)
