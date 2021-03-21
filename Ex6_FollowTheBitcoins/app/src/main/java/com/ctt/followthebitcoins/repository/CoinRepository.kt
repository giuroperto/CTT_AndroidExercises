package com.ctt.followthebitcoins.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ctt.followthebitcoins.model.*
import com.ctt.followthebitcoins.repository.services.OrderBookService
import com.ctt.followthebitcoins.repository.services.TickerService
import com.ctt.followthebitcoins.repository.services.TradesService
import com.ctt.followthebitcoins.ui.coin.CoinActivity.Companion.orderList
import com.ctt.followthebitcoins.ui.main.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat
import java.text.SimpleDateFormat

class CoinRepository {

    fun getTicker() : MutableLiveData<Ticker>{

        var tickerData : MutableLiveData<Ticker> = MutableLiveData()
        var tempTicker : Ticker

        val retrofitClient = Network.RetrofitConfig("https://www.mercadobitcoin.net/api/")
        val service = retrofitClient.create(TickerService::class.java)
        val call = service.getTicker(MainActivity.globalCoin.acronym)

        call.enqueue(
                object : Callback<TickerResponse> {
                    override fun onResponse(
                            call: Call<TickerResponse>,
                            response: Response<TickerResponse>
                    ) {
                        val responseData = response.body()

                        responseData?.let{
                            responseData.ticker?.let{

                                val responseHigh: Double = responseData.ticker.high
                                val responseLow: Double = responseData.ticker.low
                                val responseVol: Double = responseData.ticker.vol
                                val responseLast: Double = responseData.ticker.last
                                val responseBuy: Double = responseData.ticker.buy
                                val responseSell: Double = responseData.ticker.sell
                                val responseDate: Double = responseData.ticker.date

                                val dateMiliseconds = responseDate * 1000

                                tempTicker = Ticker(high = responseHigh, low = responseLow, vol = responseVol, last = responseLast, buy = responseBuy, sell = responseSell, date = dateMiliseconds)

                                tickerData.value = tempTicker
                            }
                        }
                    }

                    override fun onFailure(call: Call<TickerResponse>, t: Throwable) {
                        Log.e("APIERROR", "${t.toString()}")
                    }

                }
        )

        return tickerData
    }

    fun getOrderbook() : MutableLiveData<MutableList<Order>> {

        val orderbookLiveData = MutableLiveData<MutableList<Order>>()
        val orderBookList : MutableList<Order> = mutableListOf()

        val retrofitClient = Network.RetrofitConfig("https://www.mercadobitcoin.net/api/")
        val service = retrofitClient.create(OrderBookService::class.java)
        val call = service.getOrderBook(MainActivity.globalCoin.acronym)

        call.enqueue(
            object : Callback<OrderBook> {
                override fun onResponse(call: Call<OrderBook>, response: Response<OrderBook>) {
                    val responseData = response.body()

                    if(response.isSuccessful && responseData != null) {

                        responseData?.let{

                            var responseOrder : Order
//                            val responseOrderLiveData = MutableLiveData<Order>()

                            responseData.asks?.let {

                                responseData.asks.map {
                                    responseOrder = Order(price = it[0], quantity = it[1], type = "asks")
                                    orderBookList.add(responseOrder)
//                                    responseOrderLiveData.value = Order(price = it[0], quantity = it[1], type = "asks")
//                                    orderbookLiveData.value?.add(responseOrder)
//                                    CoinActivity.orderList.add(responseOrder)
//                                    CoinActivity.orderList.add(responseOrderLiveData.value!!)
                                }

                            }

                            responseData.bids?.let {

                                responseData.bids.map {
                                    responseOrder = Order(price = it[0], quantity = it[1], type = "bids")
                                    orderBookList.add(responseOrder)
//                                    orderbookLiveData.value?.add(responseOrder)
//                                    CoinActivity.orderList.add(responseOrder)
                                }

                            }

//                            Log.e("LIST", CoinActivity.orderList.toString())
                            Log.e("LIST_ORDER", orderBookList.toString())

                        }
                    }

                }

                override fun onFailure(call: Call<OrderBook>, t: Throwable) {
                    Log.e("APIERROR_ORDER", "${t.toString()}")
                }

            }
        )

        orderList = orderBookList
        orderbookLiveData.value = orderBookList
        return orderbookLiveData
    }

    fun getTrades() : MutableLiveData<MutableList<Trade>> {

        val tradesLiveData = MutableLiveData<MutableList<Trade>>()
        var tradesList : MutableList<Trade> = mutableListOf()

        val retrofitClient = Network.RetrofitConfig("https://www.mercadobitcoin.net/api/")
        val service = retrofitClient.create(TradesService::class.java)
        val call = service.getTrades(MainActivity.globalCoin.acronym)

        call.enqueue(
                object : Callback<MutableList<Trade>> {

                    override fun onResponse(call: Call<MutableList<Trade>>, response: Response<MutableList<Trade>>) {
                        val responseData = response.body()

                        if(response.isSuccessful && responseData != null) {
                            responseData?.let {
                                var responseTrade : Trade

                                Log.e("TRADE_API", it.toString())

                                responseData.map {
                                    responseTrade = Trade(date = it.date, price = it.price, amount = it.amount, tid = it.tid, type = it.type)
                                    tradesList.add(responseTrade)
                                }

//                                tradesList = responseData

                                Log.e("LIST_TRADE", tradesList.toString())

                            }
                        }
                    }

                    override fun onFailure(call: Call<MutableList<Trade>>, t: Throwable) {
                        Log.e("APIERROR_TRADES", "${t.toString()}")
                    }
                }
        )

        tradesLiveData.value = tradesList
        return tradesLiveData
    }
}