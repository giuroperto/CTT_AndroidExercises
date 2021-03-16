package com.ctt.followthebitcoins.ui.orderbook

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.followthebitcoins.ui.coin.CoinActivity.Companion.orderList
import com.ctt.followthebitcoins.R
import com.ctt.followthebitcoins.model.Order
import com.google.android.material.button.MaterialButtonToggleGroup

class OrderbookFragment : Fragment() {

    private var orderType: String = ""

    private lateinit var filteredList : MutableList<Order>
    private lateinit var toggleBtn : MaterialButtonToggleGroup
    private lateinit var rvOrders : RecyclerView
    private lateinit var adapterOrderBook : OrderbookAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_orderbook, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toggleBtn = view.findViewById(R.id.tbOrders)
        rvOrders = view.findViewById(R.id.rvOrderList)

        filterArray()
        adapterOrderBook = OrderbookAdapter(filteredList)

        adapterOrderBook.notifyDataSetChanged()

        toggleBtn.addOnButtonCheckedListener{
            toggleButton, checkedId, isChecked ->

            if (isChecked) {
                if (checkedId == 2131230808) {
                    orderType = "asks"
                } else if (checkedId == 2131230809) {
                    orderType = "bids"
                } else {
                    orderType = ""
                }
            } else {
                orderType =""
            }

            filterArray()

            if (filteredList.size > 0) {
                Log.e("CHAMANDO ADAPTER", "chamando adapter logo depois")
                adapterOrderBook = OrderbookAdapter(filteredList)
            }

            rvOrders.adapter = adapterOrderBook
            rvOrders.layoutManager = LinearLayoutManager(requireContext())
            adapterOrderBook.notifyDataSetChanged()
        }

        Log.e("LISTSIZE", filteredList.size.toString())
    }

    override fun onStart() {
        super.onStart()

        Log.e("init ordertype", orderType)
        Log.e("init orderList", orderList.toString())

        if (orderList.size > 0 && orderType == "") {
            Log.e("dentro if orders", "testando dentro if")

            filteredList = orderList.filter{ order ->
                order.type == "asks"
            } as MutableList<Order>

            adapterOrderBook = OrderbookAdapter(filteredList)
            rvOrders.adapter = adapterOrderBook
            rvOrders.layoutManager = LinearLayoutManager(requireContext())
        }

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
//            adapterOrderBook.notifyDataSetChanged()
        } else {
            filteredList = orderList.filter{ order ->
                order.type == "asks"
            } as MutableList<Order>
        }

        Log.e("FILTEREDLIST", filteredList.toString())

    }
}

