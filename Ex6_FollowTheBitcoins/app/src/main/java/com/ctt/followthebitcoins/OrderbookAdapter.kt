package com.ctt.followthebitcoins

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.followthebitcoins.model.Order
import com.ctt.followthebitcoins.model.OrderBook

class OrderbookAdapter(private var orderList: MutableList<Order>, private var orderType: String) : RecyclerView.Adapter<OrderbookAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val orderQuantity: TextView = view.findViewById(R.id.txtQttValue)
        val orderPrice: TextView = view.findViewById(R.id.txtPriceValue)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderbookAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderbookAdapter.ViewHolder, position: Int) {

        var filteredArray: Array<Order>

        if (orderType == "asks") {
            filteredArray = orderList.filter { order ->
                order.type == "asks"
            }.toTypedArray()
        } else if (orderType == "bids") {
            filteredArray = orderList.filter { order ->
                order.type == "bids"
            }.toTypedArray()
        } else {
            Log.e("ORDER_TYPE_ERROR", "Something went wrong... Try again!")
        }

        Log.e("Params", orderList.toString())
        Log.e("Params", orderType)

        if (orderType == "asks") {
            holder.orderPrice.text = orderList[position].toString()
            holder.orderQuantity.text = orderList[position].toString()
        } else {
            holder.orderPrice.text = orderList[position].toString()
            holder.orderQuantity.text = orderList[position].toString()
        }

    }

    override fun getItemCount(): Int {
       return orderList.size
    }

}


//                            infoSell.text = dec.format(responseSell).toString()
//                            val dec = DecimalFormat("#,###.##")