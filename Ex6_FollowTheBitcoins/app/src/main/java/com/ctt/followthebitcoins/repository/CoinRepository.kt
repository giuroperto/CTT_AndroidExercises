package com.ctt.followthebitcoins.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ctt.followthebitcoins.model.Order
import com.ctt.followthebitcoins.model.OrderBook
import com.ctt.followthebitcoins.model.Ticker
import com.ctt.followthebitcoins.model.TickerResponse
import com.ctt.followthebitcoins.repository.services.ApiResponse
import com.ctt.followthebitcoins.repository.services.OrderBookService
import com.ctt.followthebitcoins.repository.services.TickerService
import com.ctt.followthebitcoins.ui.main.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat
import java.text.SimpleDateFormat

class CoinRepository {

    val retrofitClient = Network.RetrofitConfig("https://www.mercadobitcoin.net/api/")

    //    ------------------------------------TICKER---------------------------------------

    fun getTicker(tickerResponse: ApiResponse) {

        val service = retrofitClient.create(TickerService::class.java)
        val call = service.getTicker(MainActivity.globalCoin.acronym)

        call.enqueue(
            object : Callback<TickerResponse> {
                override fun onResponse(
                    call: Call<TickerResponse>,
                    response: Response<TickerResponse>
                ) {
                    val responseData = response.body()

                    println("debug: $responseData")

                    if (response.isSuccessful) {
                        responseData?.ticker?.let {

                            println("debug: ${responseData.ticker}")
//                            println("debug: $tickerData")

                            val tickerData : Ticker = it
                            tickerResponse.tickerSuccess(tickerData)
//                            configTicker(tickerData)

//                            if (tickerData.size == 0) {
//                                tickerData.add(it)
//                            } else {
//                                tickerData = mutableListOf()
//                                tickerData.add(it)
//                            }

//                            val notes: List<Note> = it
//                            configureList(notes)
                            // TODO: 21/03/2021 a add method that will link to recyclerview config and pass info as argument

                            println("debug: $tickerData")

//                                val dec = DecimalFormat("#,###.##")

//                                val responseHigh: Double = responseData.ticker.high
//                                val responseLow: Double = responseData.ticker.low
//                                val responseVol: Double = responseData.ticker.vol
//                                val responseLast: Double = responseData.ticker.last
//                                val responseBuy: Double = responseData.ticker.buy
//                                val responseSell: Double = responseData.ticker.sell
//                                val responseDate: Double = responseData.ticker.date
//
//                                val dateMiliseconds = responseDate * 1000
//                                val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")
//                                val dateString = dateFormat.format(dateMiliseconds)
//                                val dateAdj = String.format(dateString)

//                                infoHigh.text = dec.format(responseHigh).toString()
//                                infoLow.text = dec.format(responseLow).toString()
//                                infoVol.text = dec.format(responseVol).toString()
//                                infoLast.text = dec.format(responseLast).toString()
//                                infoBuy.text = dec.format(responseBuy).toString()
//                                infoSell.text = dec.format(responseSell).toString()
//                                infoDate.text = dateAdj

                        }
                    }
                }

                override fun onFailure(call: Call<TickerResponse>, t: Throwable) {
                    Log.e("APIERROR", "${t.toString()}")
                }

            }
        )
    }


    //                        private fun configureList(notes: List<Note>) {
//                            val recyclerView = note_list_recyclerview
//                            recyclerView.adapter = NoteListAdapter(notes, this)
//                            val layoutManager = StaggeredGridLayoutManager(
//                                    2, StaggeredGridLayoutManager.VERTICAL)
//                            recyclerView.layoutManager = layoutManager
//                        }

    //    ------------------------------------ORDERBOOK---------------------------------------

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
                            Log.e("LIST", orderBookList.toString())

                        }
                    }

                }

                override fun onFailure(call: Call<OrderBook>, t: Throwable) {
                    Log.e("APIERROR", "${t.toString()}")
                }

            }
        )

        orderbookLiveData.value = orderBookList

        return orderbookLiveData
    }
}