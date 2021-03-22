package com.ctt.followthebitcoins.ui.orderbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.followthebitcoins.R
import com.ctt.followthebitcoins.model.Order
import com.ctt.followthebitcoins.model.OrderBook
import java.text.DecimalFormat

class OrderbookAdapter(private var orderbookList: OrderBook, private var orderType: String) : RecyclerView.Adapter<OrderbookAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val orderQuantity: TextView = view.findViewById(R.id.txtQttValue)
        val orderPrice: TextView = view.findViewById(R.id.txtPriceValue)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val dec = DecimalFormat("#,###.######")

        if (orderType == "asks") {
            println("debug: ASKS")
            holder.orderPrice.text = dec.format(orderbookList.asks[position][0]).toString()
            holder.orderQuantity.text = dec.format(orderbookList.asks[position][1]).toString()
        } else if (orderType == "bids") {
            println("debug: BIDS")
            holder.orderPrice.text = dec.format(orderbookList.bids[position][0]).toString()
            holder.orderQuantity.text = dec.format(orderbookList.bids[position][1]).toString()
        }

    }

    override fun getItemCount(): Int {

        var arraySize : Int = 0

        if (orderType == "asks") {
            arraySize = orderbookList.asks.size
        } else if (orderType == "bids") {
            arraySize = orderbookList.bids.size
        }
        return arraySize
    }

}

// TODO: 22/03/2021 refactor to show in only one list