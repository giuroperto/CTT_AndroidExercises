package com.ctt.followthebitcoins.ui.coin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.ctt.followthebitcoins.R
import com.ctt.followthebitcoins.ui.main.MainActivity.Companion.globalCoin
import com.ctt.followthebitcoins.model.Coin

class CoinsAdapter(private val coinsList: MutableList<Coin>) : RecyclerView.Adapter<CoinsAdapter.ViewHolder>() {

    private lateinit var contextHere: Context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val coinAcronym: TextView = view.findViewById(R.id.txtCoin)
        val coinName: TextView = view.findViewById(R.id.txtNameCoin)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false)

        contextHere = parent.context

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.coinAcronym.text = coinsList[position].acronym
        holder.coinName.text = coinsList[position].name

        holder.itemView.setOnClickListener{

            val selectedCoin = coinsList[position]
            globalCoin = selectedCoin

            redirect(selectedCoin)
        }
    }

    override fun getItemCount(): Int {
        return coinsList.size
    }

    fun redirect(coin: Coin) {

        val coinKey = "COIN"

        val targetActivity = Intent(contextHere, CoinActivity::class.java)
        targetActivity.putExtra(coinKey, coin)

        startActivity(contextHere, targetActivity, null)
    }
}