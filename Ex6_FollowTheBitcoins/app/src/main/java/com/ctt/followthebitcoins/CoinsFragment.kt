package com.ctt.followthebitcoins

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.followthebitcoins.model.Coin

class CoinsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_coins, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coinsList = mutableListOf(
            Coin(acronym = "ACORDO01", name = "None"),
            Coin(acronym = "ASRFT", name = "Fan Token ASR"),
            Coin(acronym = "ATMFT", name = "Fan Token ATM"),
            Coin(acronym = "BCH", name = "Bitcoin Cash"),
            Coin(acronym = "BTC", name = "Bitcoin"),
            Coin(acronym = "CAIFT", name = "Fan Token CAI"),
            Coin(acronym = "CHZ", name = "Chiliz"),
            Coin(acronym = "ETH", name = "Ethereum"),
            Coin(acronym = "GALFT", name = "Fan Token GAL"),
            Coin(acronym = "IMOB01", name = "None"),
            Coin(acronym = "JUVFT", name = "Fan Token JUV"),
            Coin(acronym = "LINK", name = "CHAINLINK"),
            Coin(acronym = "LTC", name = "Litecoin"),
            Coin(acronym = "MBCONS01", name = "Cota de Consórcio 01"),
            Coin(acronym = "MBCONS02", name = "Cota de Consórcio 02"),
            Coin(acronym = "MBFP01", name = "None"),
            Coin(acronym = "MBFP02", name = "None"),
            Coin(acronym = "MBPRK01", name = "Precatório MB SP01"),
            Coin(acronym = "MBPRK02", name = "Precatório MB SP02"),
            Coin(acronym = "MBPRK03", name = "Precatório MB BR03"),
            Coin(acronym = "MBPRK04", name = "Precatório MB RJ04"),
            Coin(acronym = "MBVASCO01", name = "MBVASCO01"),
            Coin(acronym = "MCO2", name = "MCO2"),
            Coin(acronym = "PAXG", name = "PAX Gold"),
            Coin(acronym = "PSGFT", name = "Fan Token PSG"),
            Coin(acronym = "USDC", name = "USD Coin"),
            Coin(acronym = "WBX", name = "WiBX"),
            Coin(acronym = "XRP", name = "XRP")
        )

        val rvCoins = view.findViewById<RecyclerView>(R.id.rvCoins)

        val adapterCoins = CoinsAdapter(coinsList)
        rvCoins.adapter = adapterCoins
        rvCoins.layoutManager = LinearLayoutManager(requireContext())
    }
}
