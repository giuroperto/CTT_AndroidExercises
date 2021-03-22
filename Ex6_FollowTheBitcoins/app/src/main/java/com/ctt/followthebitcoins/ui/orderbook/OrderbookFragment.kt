package com.ctt.followthebitcoins.ui.orderbook

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.followthebitcoins.R
import com.ctt.followthebitcoins.model.Order
import com.ctt.followthebitcoins.model.OrderBook
import com.ctt.followthebitcoins.repository.services.OrderbookApiResponse
import com.ctt.followthebitcoins.ui.coin.CoinActivityViewModel
import com.google.android.material.button.MaterialButtonToggleGroup

class OrderbookFragment : Fragment() {

    private var orderType: String = "asks"

    private lateinit var toggleBtn : MaterialButtonToggleGroup
    private lateinit var rvOrders : RecyclerView
    private lateinit var adapterOrderBook : OrderbookAdapter

    private val viewModel = CoinActivityViewModel()
    val coinRepository = viewModel.getCoinRepo()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_orderbook, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvOrders = view.findViewById(R.id.rvOrderList)

        getOrderbook()

        toggleBtn = view.findViewById(R.id.tbOrders)

        toggleBtn.addOnButtonCheckedListener{
            toggleButton, checkedId, isChecked ->

            if (isChecked) {
                if (checkedId == 2131230808) {
                    println("debug: inside ASKS")
                    orderType = "asks"
                } else if (checkedId == 2131230809) {
                    println("debug: inside bids")
                    orderType = "bids"
                } else {
                    // default
                    orderType = "asks"
                    println("debug: inside default")
                }
            } else {
                orderType =""
                println("debug: inside none")
            }

            getOrderbook()
        }
    }

    private fun configureOrderbook(orderbookData: OrderBook) {
        adapterOrderBook = OrderbookAdapter(orderbookData, orderType)
        rvOrders.adapter = adapterOrderBook
        rvOrders.layoutManager = LinearLayoutManager(requireContext())
    }

    fun getOrderbook() {
        coinRepository.getOrderbook(
            object: OrderbookApiResponse {

                override fun success(orderbook: OrderBook) {
                    configureOrderbook(orderbook)
                }

            }
        )
    }
}

// TODO: 22/03/2021 add loader so it will only show app when fetch a response from api