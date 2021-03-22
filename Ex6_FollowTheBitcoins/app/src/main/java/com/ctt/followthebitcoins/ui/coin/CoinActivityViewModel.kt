package com.ctt.followthebitcoins.ui.coin

import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ctt.followthebitcoins.model.Order
import com.ctt.followthebitcoins.model.Ticker
import com.ctt.followthebitcoins.model.Trade
import com.ctt.followthebitcoins.repository.CoinRepository
import com.ctt.followthebitcoins.ui.coin.CoinActivity.Companion.tickerData

class CoinActivityViewModel(
    private val coinRepository: CoinRepository = CoinRepository()
) : ViewModel() {
    private lateinit var orderbookLiveData : MutableLiveData<MutableList<Order>>
    private lateinit var tradesLiveData : MutableLiveData<MutableList<Trade>>
    private lateinit var tickerApiData : MutableLiveData<Ticker>
    private var loading : Boolean = false

    fun getAllData() {
        val task = TaskTicker()
        task.execute()
    }

    fun getTicker(result: MutableLiveData<Ticker>) : MutableLiveData<Ticker> {
        Log.e("INFO TICKER", result.toString())
        tickerApiData = result
        return tickerApiData
    }

    fun getOrderBook() : MutableLiveData<MutableList<Order>> {
        orderbookLiveData = coinRepository.getOrderbook()
        return orderbookLiveData
    }

    fun getTrades() : MutableLiveData<MutableList<Trade>> {
        tradesLiveData = coinRepository.getTrades()
        return tradesLiveData
    }

    fun showLoadingIndicator() {
        loading = true
    }

    fun hideLoadingIndicator() {
        loading = false
    }

    fun getLoading() : Boolean {
        return loading
    }

    inner class TaskTicker() : AsyncTask<Void, Int, MutableLiveData<Ticker>>() {

        override fun onPreExecute() {
            super.onPreExecute()
            showLoadingIndicator()
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
        }

        override fun doInBackground(vararg params: Void?): MutableLiveData<Ticker> {
            onProgressUpdate()
            Log.e("DOINBACK", "here")
            return coinRepository.getTicker()
        }

        override fun onPostExecute(result: MutableLiveData<Ticker>) {
            super.onPostExecute(result)
            hideLoadingIndicator()
            Log.e("OnPost", result.toString())
            result?.let {
                getTicker(result)
            }
        }

    }
}