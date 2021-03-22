package com.ctt.followthebitcoins.repository

import android.util.Log
import com.ctt.followthebitcoins.model.OrderBook
import com.ctt.followthebitcoins.model.Ticker
import com.ctt.followthebitcoins.model.TickerResponse
import com.ctt.followthebitcoins.repository.services.OrderBookService
import com.ctt.followthebitcoins.repository.services.OrderbookApiResponse
import com.ctt.followthebitcoins.repository.services.TickerApiResponse
import com.ctt.followthebitcoins.repository.services.TickerService
import com.ctt.followthebitcoins.ui.main.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoinRepository {

    val retrofitClient = Network.RetrofitConfig("https://www.mercadobitcoin.net/api/")

    //    ------------------------------------TICKER---------------------------------------

    fun getTicker(tickerApiResponse: TickerApiResponse) {

        val service = retrofitClient.create(TickerService::class.java)
        val call = service.getTicker(MainActivity.globalCoin.acronym)

        call.enqueue(
            object : Callback<TickerResponse> {
                override fun onResponse(
                    call: Call<TickerResponse>,
                    response: Response<TickerResponse>
                ) {
                    val responseData = response.body()

                    if (response.isSuccessful) {
                        responseData?.ticker?.let {
                            val tickerData : Ticker = it
                            tickerApiResponse.success(tickerData)
                        }
                    }
                }

                override fun onFailure(call: Call<TickerResponse>, t: Throwable) {
                    Log.e("APIERROR", "${t.toString()}")
                }

            }
        )
    }

    //    ------------------------------------ORDERBOOK---------------------------------------

    fun getOrderbook(orderbookApiResponse: OrderbookApiResponse) {

        val service = retrofitClient.create(OrderBookService::class.java)
        val call = service.getOrderBook(MainActivity.globalCoin.acronym)

        call.enqueue(
            object : Callback<OrderBook> {
                override fun onResponse(call: Call<OrderBook>, response: Response<OrderBook>) {
                    val responseData = response.body()

                    if(response.isSuccessful) {
                        responseData?.let{

                            val orderbookData : OrderBook = it
                            orderbookApiResponse.success(orderbookData)
                        }
                    }
                }

                override fun onFailure(call: Call<OrderBook>, t: Throwable) {
                    Log.e("APIERROR", "${t.toString()}")
                }

            }
        )
    }
}
