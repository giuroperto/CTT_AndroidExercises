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

class OrderbookAdapter(private var orderFilteredList: MutableList<Order>) : RecyclerView.Adapter<OrderbookAdapter.ViewHolder>() {

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

        holder.orderPrice.text = dec.format(orderFilteredList[position].price).toString()
        holder.orderQuantity.text = dec.format(orderFilteredList[position].quantity).toString()
    }

    override fun getItemCount(): Int {
        if (orderFilteredList.size == 0) {
            return 1
        } else {
            return orderFilteredList.size
        }
    }

}
