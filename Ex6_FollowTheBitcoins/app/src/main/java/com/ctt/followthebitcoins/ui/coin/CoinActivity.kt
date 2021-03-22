package com.ctt.followthebitcoins.ui.coin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.ctt.followthebitcoins.PageAdapter
import com.ctt.followthebitcoins.R
import com.ctt.followthebitcoins.model.Order
import com.ctt.followthebitcoins.model.OrderBook
import com.ctt.followthebitcoins.model.Ticker
import com.ctt.followthebitcoins.model.Trade
import com.ctt.followthebitcoins.repository.Network
import com.ctt.followthebitcoins.repository.services.OrderBookService
import com.ctt.followthebitcoins.ui.main.MainActivity
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoinActivity : AppCompatActivity() {


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        button_load_data.setOnClickListener{
//            launchAstroTask()
//        }
//    }
//


    private val viewModel = CoinActivityViewModel()
    private lateinit var progressBar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin)

        val tabLayout = findViewById<TabLayout>(R.id.tbMenu)
        val viewPager = findViewById<ViewPager>(R.id.vwTabs)

        viewModel.getAllData().observe(

        )

//        loadData()
        getApiOrderbook()
        getApiTrades()

        viewPager.adapter = PageAdapter(supportFragmentManager, this)
        tabLayout.setupWithViewPager(viewPager)
    }

    fun loadData() {
        var loading: Boolean = viewModel.getLoading()

        if (loading) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    fun getApiOrderbook() {
        viewModel.getOrderBook().observe(
            this,
            object : Observer<MutableList<Order>> {
                override fun onChanged(t: MutableList<Order>?) {
                    t?.let {
                        orderList = t
                    }
                }

            }
        )
    }

    fun getApiTrades() {
        viewModel.getTrades().observe(
            this,
            object : Observer<MutableList<Trade>> {

                override fun onChanged(t: MutableList<Trade>?) {
                    t?.let {
                        tradesList = t
                    }
                }

            }
        )
    }

    override fun onStart() {
        super.onStart()

        if (orderList.size == 0) {
            viewModel.getOrderBook()
        }

        if (tradesList.size == 0) {
            viewModel.getTrades()
        }

        if (tickerData == null) {
//            viewModel.getTicker()
        }
    }

    companion object {
        var tickerData : Ticker? = null
        var orderList: MutableList<Order> = mutableListOf()
        var tradesList: MutableList<Trade> = mutableListOf()
    }
}