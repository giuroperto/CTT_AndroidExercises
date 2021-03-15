package com.ctt.followthebitcoins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.ctt.followthebitcoins.model.Coin
import com.ctt.followthebitcoins.model.Order
import com.ctt.followthebitcoins.model.OrderBook
import com.ctt.followthebitcoins.services.OrderBookService
import com.ctt.followthebitcoins.services.TickerService
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin)

        val tabLayout = findViewById<TabLayout>(R.id.tbMenu)
        val viewPager = findViewById<ViewPager>(R.id.vwTabs)

        viewPager.adapter = PageAdapter(supportFragmentManager, this)
        tabLayout.setupWithViewPager(viewPager)

        runBlocking {
            getOrderbook()
        }
    }

    override fun onStart() {
        super.onStart()

        if (orderList.size == 0) {
            getOrderbook()

        }
    }

    fun getOrderbook() {

        val retrofitClient = Network.RetrofitConfig("https://www.mercadobitcoin.net/api/")
        val service = retrofitClient.create(OrderBookService::class.java)
        val call = service.getOrderBook(MainActivity.globalCoin.acronym)

        call.enqueue(
                object : Callback<OrderBook> {
                    override fun onResponse(call: Call<OrderBook>, response: Response<OrderBook>) {
                        val responseData = response.body()

                        responseData?.let{

                            var responseOrder : Order

                            responseData.asks?.let {

                                responseData.asks.map {
                                    responseOrder = Order(price = it[0], quantity = it[1], type = "asks")
                                    orderList.add(responseOrder)
                                }

                            }

                            responseData.bids?.let {

                                responseData.bids.map {
                                    responseOrder = Order(price = it[0], quantity = it[1], type = "bids")
                                    orderList.add(responseOrder)
                                }

                            }

                            Log.e("LIST", orderList.toString())

                        }
                    }

                    override fun onFailure(call: Call<OrderBook>, t: Throwable) {
                        Log.e("APIERROR", "${t.toString()}")
                    }

                }
        )
    }

    companion object {
        var orderList: MutableList<Order> = mutableListOf()
    }
}