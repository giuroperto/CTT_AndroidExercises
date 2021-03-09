package com.ctt.followthebitcoins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.ctt.followthebitcoins.model.Coin
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        val rvCoins = findViewById<RecyclerView>(R.id.rvCoins)

        val adapterCoins = CoinsAdapter(coinsList)
        rvCoins.adapter = adapterCoins

        rvCoins.layoutManager = LinearLayoutManager(this)

//        chooseCoin()
    }



//    rvCoins.layoutManager = LinearLayoutManager(requireContext())

//    fun chooseCoin() {
//        val items = arrayOf("Item 1", "Item 2", "Item 3")
//        val checkedItem = 1
//
//        MaterialAlertDialogBuilder(this)
//            .setTitle(resources.getString(R.string.app_dialogTitle))
//            .setNeutralButton(resources.getString(R.string.app_dialogCancel)) { dialog, which ->
//                // Respond to neutral button press
//            }
//            .setPositiveButton(resources.getString(R.string.app_dialogOk)) { dialog, which ->
//                // Respond to positive button press
//            }
//            // Single-choice items (initialized with checked item)
//            .setSingleChoiceItems(items, checkedItem) { dialog, which ->
//                // Respond to item chosen
//            }
//            .show()
//    }
}
