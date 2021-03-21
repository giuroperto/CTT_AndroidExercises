package com.ctt.followthebitcoins.ui.trades

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
import com.ctt.followthebitcoins.model.Trade
import com.ctt.followthebitcoins.ui.coin.CoinActivity
import com.ctt.followthebitcoins.ui.coin.CoinActivity.Companion.tradesList
import com.ctt.followthebitcoins.ui.orderbook.OrderbookAdapter
import com.google.android.material.button.MaterialButtonToggleGroup

class TradesFragment : Fragment() {

    private lateinit var rvTrades : RecyclerView
    private lateinit var adapterTrades : TradesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trades, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvTrades = view.findViewById(R.id.rvTradesList)
        adapterTrades = TradesAdapter(tradesList)

        if (tradesList.size > 0) {
            adapterTrades = TradesAdapter(tradesList)
        }

        rvTrades.adapter = adapterTrades
        rvTrades.layoutManager = LinearLayoutManager(requireContext())
        adapterTrades.notifyDataSetChanged()

    }

    override fun onStart() {
        super.onStart()

        Log.e("init tradelist", tradesList.toString())

        if (CoinActivity.tradesList.size > 0) {

            adapterTrades = TradesAdapter(tradesList)
            rvTrades.adapter = adapterTrades
            rvTrades.layoutManager = LinearLayoutManager(requireContext())

        }

    }

}



