package com.ctt.followthebitcoins

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ctt.followthebitcoins.ui.orderbook.OrderbookFragment
import com.ctt.followthebitcoins.ui.ticker.TickerFragment
import com.ctt.followthebitcoins.ui.trades.TradesFragment

//import com.ctt.followthebitcoins.model.Ticker

class PageAdapter(fm: FragmentManager, pageAdapterContext: Context) : FragmentPagerAdapter(fm){

    var contextHere = pageAdapterContext

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
//            TICKER
            0 -> TickerFragment()
//            ORDERBOOK
            1 -> OrderbookFragment()
//            TRADES
            2 -> TradesFragment()
//            DEFAULT
            else -> TickerFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
//            TICKER
            0 -> contextHere.getString(R.string.app_ticker)
//            ORDERBOOK
            1 -> contextHere.getString(R.string.app_orderbook)
//            TRADES
            2 -> contextHere.getString(R.string.app_trades)
//            DEFAULT
            else -> super.getPageTitle(position)
        }
    }
}
