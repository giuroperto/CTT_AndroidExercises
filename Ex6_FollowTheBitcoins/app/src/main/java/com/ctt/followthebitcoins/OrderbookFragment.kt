package com.ctt.followthebitcoins

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.followthebitcoins.CoinActivity.Companion.orderList
import com.ctt.followthebitcoins.model.Order
import com.ctt.followthebitcoins.model.OrderBook
import com.ctt.followthebitcoins.model.TickerResponse
import com.ctt.followthebitcoins.services.OrderBookService
import com.ctt.followthebitcoins.services.TickerService
import com.google.android.material.button.MaterialButtonToggleGroup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat
import java.text.SimpleDateFormat

class OrderbookFragment : Fragment() {

    private var orderType: String = ""

    private var filteredList : MutableList<Order> = orderList

    private lateinit var toggleBtn : MaterialButtonToggleGroup
    private lateinit var rvOrders : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_orderbook, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e("OrderList", orderList.toString())

        toggleBtn = view.findViewById(R.id.tbOrders)

        toggleBtn.addOnButtonCheckedListener{
            toggleButton, checkedId, isChecked ->

            if (isChecked) {
                if (checkedId == 2131230808) {
                    orderType = "asks"
                    filterArray()
                } else if (checkedId == 2131230809) {
                    orderType = "bids"
                    filterArray()
                } else {
                    // default
                    orderType = "asks"
                    filterArray()
                }
            } else {
                orderType =""
                filterArray()
            }
        }

        rvOrders = view.findViewById(R.id.rvOrderList)
        val adapterOrderBook = OrderbookAdapter(filteredList)
        rvOrders.adapter = adapterOrderBook
        rvOrders.layoutManager = LinearLayoutManager(requireContext())

    }

    fun filterArray() {

        Log.e("Filter", "inside filter")
        Log.e("FilterType", orderType)

        if (orderType == "asks") {
            filteredList = orderList.filter{ order ->
                order.type == "asks"
            } as MutableList<Order>
        } else if (orderType == "bids") {
            filteredList = orderList.filter {
                order ->
                order.type == "bids"
            } as MutableList<Order>
        } else {
            filteredList = orderList
            Log.e("ORDER_TYPE_ERROR", "No selection was made... Try again!")
        }

        Log.e("FILTEREDLIST", filteredList.toString())

    }
}
