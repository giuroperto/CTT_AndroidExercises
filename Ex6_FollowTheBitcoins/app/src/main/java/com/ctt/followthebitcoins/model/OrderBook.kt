package com.ctt.followthebitcoins.model

import com.google.gson.annotations.SerializedName

data class OrderBook(
        val asks: Array<Array<Double>>,
        val bids: Array<Array<Double>>,
        ) {

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as OrderBook

                if (!asks.contentEquals(other.asks)) return false
                if (!bids.contentEquals(other.bids)) return false

                return true
        }

        override fun hashCode(): Int {
                var result = asks.contentHashCode()
                result = 31 * result + bids.contentHashCode()
                return result
        }
}

data class Order(var price: Double, var quantity: Double, var type: String)