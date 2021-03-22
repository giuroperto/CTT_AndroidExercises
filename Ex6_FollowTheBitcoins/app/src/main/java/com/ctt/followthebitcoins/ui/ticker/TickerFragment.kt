package com.ctt.followthebitcoins.ui.ticker

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ctt.followthebitcoins.R
import com.ctt.followthebitcoins.model.Ticker
import com.ctt.followthebitcoins.ui.main.MainActivity.Companion.globalCoin
import com.ctt.followthebitcoins.repository.services.ApiResponse
import com.ctt.followthebitcoins.ui.coin.CoinActivityViewModel
import java.text.DecimalFormat
import java.text.SimpleDateFormat

class TickerFragment : Fragment() {

    private lateinit var infoHigh: TextView
    private lateinit var  infoLow: TextView
    private lateinit var  infoVol: TextView
    private lateinit var  infoLast: TextView
    private lateinit var  infoBuy: TextView
    private lateinit var  infoSell: TextView
    private lateinit var  infoDate: TextView
    private lateinit var  coinAcr: TextView
    private lateinit var  coinName: TextView

    private val viewModel = CoinActivityViewModel()
    val coinRepository = viewModel.getCoinRepo()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ticker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        infoHigh = view.findViewById(R.id.txtHighValue)
        infoLow = view.findViewById(R.id.txtLowValue)
        infoVol = view.findViewById(R.id.txtVolValue)
        infoLast = view.findViewById(R.id.txtLastValue)
        infoBuy = view.findViewById(R.id.txtBuyValue)
        infoSell = view.findViewById(R.id.txtSellValue)
        infoDate = view.findViewById(R.id.txtDateValue)

        coinAcr = view.findViewById(R.id.txtAcr)
        coinName = view.findViewById(R.id.txtName)

        coinAcr.text = globalCoin.acronym
        coinName.text = globalCoin.name

        getTickerData()
    }

    fun getTicker(ticker: Ticker) {
        val dec = DecimalFormat("#,###.##")

        val dateMiliseconds = ticker.date * 1000
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")
        val dateString = dateFormat.format(dateMiliseconds)
        val dateAdj = String.format(dateString)

        infoHigh.text = dec.format(ticker.high).toString()
        infoLow.text = dec.format(ticker.low).toString()
        infoVol.text = dec.format(ticker.vol).toString()
        infoLast.text = dec.format(ticker.last).toString()
        infoBuy.text = dec.format(ticker.buy).toString()
        infoSell.text = dec.format(ticker.sell).toString()
        infoDate.text = dateAdj
    }

    fun getTickerData() {
        coinRepository.getTicker(

            object: ApiResponse {

                override fun tickerSuccess(ticker: Ticker) {
                    getTicker(ticker)
                }

            }
        )
    }
}
