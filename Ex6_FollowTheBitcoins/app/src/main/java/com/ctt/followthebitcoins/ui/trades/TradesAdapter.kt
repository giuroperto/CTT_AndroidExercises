package com.ctt.followthebitcoins.ui.trades

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.followthebitcoins.R
import com.ctt.followthebitcoins.model.Order
import com.ctt.followthebitcoins.model.Trade
import java.text.DecimalFormat
import java.text.SimpleDateFormat

class TradesAdapter(private var tradesList: MutableList<Trade>) : RecyclerView.Adapter<TradesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val tradeQuantity : TextView = view.findViewById(R.id.txtTradeAmountValue)
        val tradePrice : TextView = view.findViewById(R.id.txtTradePriceValue)
        val tradeDate : TextView = view.findViewById(R.id.txtTradeDateValue)
        val tradeType : TextView = view.findViewById(R.id.txtTradeType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TradesAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TradesAdapter.ViewHolder, position: Int) {
        val dec = DecimalFormat("#,###.######")

        val dateMiliseconds = tradesList[position].date * 1000
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")
        val dateString = dateFormat.format(dateMiliseconds)
        val dateAdj = String.format(dateString)

        holder.tradeDate.text = dateAdj
        holder.tradePrice.text = dec.format(tradesList[position].price).toString()
//        holder.tradeQuantity.text = dec.format(tradesList[position].amount).toString()
        holder.tradeType.text = tradesList[position].type
    }

    override fun getItemCount(): Int = tradesList.size
}
