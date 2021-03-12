package com.ctt.followthebitcoins

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.followthebitcoins.model.Order
import com.ctt.followthebitcoins.model.OrderBook
import java.text.DecimalFormat

class OrderbookAdapter(private var orderList: MutableList<Order>) : RecyclerView.Adapter<OrderbookAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val orderQuantity: TextView = view.findViewById(R.id.txtQttValue)
        val orderPrice: TextView = view.findViewById(R.id.txtPriceValue)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderbookAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderbookAdapter.ViewHolder, position: Int) {

        val dec = DecimalFormat("#,###.##")

        Log.e("Params", orderList.toString())

        holder.orderPrice.text = dec.format(orderList[position]).toString()
        holder.orderQuantity.text = dec.format(orderList[position]).toString()
    }

    override fun getItemCount(): Int {
       return orderList.size
    }

}
