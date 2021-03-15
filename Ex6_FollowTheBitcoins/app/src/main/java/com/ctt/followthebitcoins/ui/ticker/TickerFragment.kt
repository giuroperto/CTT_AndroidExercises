package com.ctt.followthebitcoins.ui.ticker

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ctt.followthebitcoins.R
import com.ctt.followthebitcoins.ui.main.MainActivity.Companion.globalCoin
import com.ctt.followthebitcoins.model.TickerResponse
import com.ctt.followthebitcoins.repository.Network
import com.ctt.followthebitcoins.repository.services.TickerService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

        getTicker()
    }

    fun getTicker() {
        val retrofitClient = Network.RetrofitConfig("https://www.mercadobitcoin.net/api/")

        val service = retrofitClient.create(TickerService::class.java)

        val call = service.getTicker(globalCoin.acronym)

        call.enqueue(
            object : Callback<TickerResponse> {
                override fun onResponse(
                    call: Call<TickerResponse>,
                    response: Response<TickerResponse>
                ) {
                    val responseData = response.body()

                    responseData?.let{
                        responseData.ticker?.let{

                            val dec = DecimalFormat("#,###.##")

                            val responseHigh: Double = responseData.ticker.high
                            val responseLow: Double = responseData.ticker.low
                            val responseVol: Double = responseData.ticker.vol
                            val responseLast: Double = responseData.ticker.last
                            val responseBuy: Double = responseData.ticker.buy
                            val responseSell: Double = responseData.ticker.sell
                            val responseDate: Double = responseData.ticker.date

                            val dateMiliseconds = responseDate * 1000
                            val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")
                            val dateString = dateFormat.format(dateMiliseconds)
                            val dateAdj = String.format(dateString)

                            infoHigh.text = dec.format(responseHigh).toString()
                            infoLow.text = dec.format(responseLow).toString()
                            infoVol.text = dec.format(responseVol).toString()
                            infoLast.text = dec.format(responseLast).toString()
                            infoBuy.text = dec.format(responseBuy).toString()
                            infoSell.text = dec.format(responseSell).toString()
                            infoDate.text = dateAdj
                        }
                    }
                }

                override fun onFailure(call: Call<TickerResponse>, t: Throwable) {
                    Log.e("APIERROR", "${t.toString()}")
                }

            }
        )
    }
}
