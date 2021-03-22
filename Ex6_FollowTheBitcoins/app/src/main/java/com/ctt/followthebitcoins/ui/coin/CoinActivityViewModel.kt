package com.ctt.followthebitcoins.ui.coin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ctt.followthebitcoins.model.Order
import com.ctt.followthebitcoins.model.Ticker
import com.ctt.followthebitcoins.repository.CoinRepository
import com.ctt.followthebitcoins.ui.ticker.TickerFragment

class CoinActivityViewModel(
    private val coinRepository: CoinRepository = CoinRepository()
) : ViewModel() {

    private lateinit var orderbookLiveData : MutableLiveData<MutableList<Order>>

    fun getCoinRepo() : CoinRepository {
        return coinRepository
    }

//    var tickerData: MutableList<Ticker> = mutableListOf()
//
//    fun getTickerData() : Ticker {
//        return tickerData[0]
//    }
//
//    fun setTickerData(ticker: Ticker) {
////        TickerFragment(ticker)
//    }

    //    ------------------------------------TICKER---------------------------------------

//    fun getTicker() {
//        coinRepository.getTicker(
//
//            object: ApiResponse {
//
//                override fun tickerSuccess(ticker: Ticker) {
//                    setTickerData(ticker)
//                }
//
//            }
//        )
//    }

//    private fun configureList(notes: List<Note>) {
//        val recyclerView = note_list_recyclerview
//        recyclerView.adapter = NoteListAdapter(notes, this)
//        val layoutManager = StaggeredGridLayoutManager(
//            2, StaggeredGridLayoutManager.VERTICAL)
//        recyclerView.layoutManager = layoutManager
//    }


//    override fun onCreate(savedInstanceState: Bundle?) {
//        // restante do código
//        NoteWebClient().list()
//    }


    // TODO: 22/03/2021 add activity logic to viewmodel 
    
}