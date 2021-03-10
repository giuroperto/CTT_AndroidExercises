package com.ctt.followthebitcoins

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.followthebitcoins.MainActivity.Companion.globalCoin
import com.ctt.followthebitcoins.model.Coin
import com.ctt.followthebitcoins.model.Ticker
import com.ctt.followthebitcoins.model.TickerResponse
import com.ctt.followthebitcoins.services.TickerService
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat
import java.time.format.DateTimeFormatter

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

//                            var formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")

                            val responseHigh: Double = responseData.ticker.high
                            val responseLow: Double = responseData.ticker.low
                            val responseVol: Double = responseData.ticker.vol
                            val responseLast: Double = responseData.ticker.last
                            val responseBuy: Double = responseData.ticker.buy
                            val responseSell: Double = responseData.ticker.sell
                            val responseDate: Double = responseData.ticker.date


                            infoHigh.text = dec.format(responseHigh).toString()
                            infoLow.text = dec.format(responseLow).toString()
                            infoVol.text = dec.format(responseVol).toString()
                            infoLast.text = dec.format(responseLast).toString()
                            infoBuy.text = dec.format(responseBuy).toString()
                            infoSell.text = dec.format(responseSell).toString()
//                            infoDate.text = responseDate.format(formatter).toString()
                        }
                    }
                }

                override fun onFailure(call: Call<TickerResponse>, t: Throwable) {
                    Log.e("APIRESPONSEE", "${t.toString()}")
                }

            }
        )
    }
}

//val statusList = mutableListOf<Status>(
//    Status(picture = null, name = "Giulia", time = "20 minutes ago"),
//    Status(picture = null, name = "Henrique", time = "25 minutes ago"),
//    Status(picture = null, name = "Afonso", time = "40 minutes ago"),
//    Status(picture = null, name = "Cristina", time = "1h ago"),
//    Status(picture = null, name = "Daniel", time = "5h ago"),
//)
//
//val rvStatus = view.findViewById<RecyclerView>(R.id.statusList)
//
//val adapterStatus = StatusAdapter(statusList)
//rvStatus.adapter = adapterStatus
//rvStatus.layoutManager = LinearLayoutManager(requireContext())
