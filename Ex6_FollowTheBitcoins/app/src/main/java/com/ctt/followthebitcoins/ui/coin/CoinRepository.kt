package com.ctt.followthebitcoins.ui.coin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ctt.followthebitcoins.model.Order
import com.ctt.followthebitcoins.model.OrderBook
import com.ctt.followthebitcoins.repository.Network
import com.ctt.followthebitcoins.repository.services.OrderBookService
import com.ctt.followthebitcoins.ui.main.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoinRepository {

    fun getOrderbook() : MutableLiveData<OrderBook> {

        val orderbookLiveData = MutableLiveData<OrderBook>()

        val retrofitClient = Network.RetrofitConfig("https://www.mercadobitcoin.net/api/")
        val service = retrofitClient.create(OrderBookService::class.java)
        val call = service.getOrderBook(MainActivity.globalCoin.acronym)

        call.enqueue(
            object : Callback<OrderBook> {
                override fun onResponse(call: Call<OrderBook>, response: Response<OrderBook>) {
                    val responseData = response.body()

                    if(response.isSuccessful && responseData != null) {

                        responseData?.let{

//                            var responseOrder : Order
                            val responseOrderLiveData = MutableLiveData<Order>()

                            responseData.asks?.let {

                                responseData.asks.map {
//                                    responseOrder = Order(price = it[0], quantity = it[1], type = "asks")
                                    responseOrderLiveData.value = Order(price = it[0], quantity = it[1], type = "asks")
//                                    CoinActivity.orderList.add(responseOrder)
                                    CoinActivity.orderList.add(responseOrderLiveData.value!!)
                                }

                            }

                            responseData.bids?.let {

                                responseData.bids.map {
                                    responseOrderLiveData.value = Order(price = it[0], quantity = it[1], type = "bids")
                                    CoinActivity.orderList.add(responseOrderLiveData.value!!)
                                }

                            }

                            Log.e("LIST", CoinActivity.orderList.toString())

                        }
                    }

                }

                override fun onFailure(call: Call<OrderBook>, t: Throwable) {
                    Log.e("APIERROR", "${t.toString()}")
                }

            }
        )
        return orderbookLiveData
    }
}