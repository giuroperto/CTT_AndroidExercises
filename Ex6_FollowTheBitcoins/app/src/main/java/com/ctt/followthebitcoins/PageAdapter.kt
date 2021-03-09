package com.ctt.followthebitcoins

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(fm: FragmentManager, pageAdapterContext: Context) : FragmentPagerAdapter(fm){

    var contextHere = pageAdapterContext

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
//            TICKER
            0 -> CoinsFragment()
//            ORDERBOOK
            1 -> CoinsFragment()
//            TRADES
            2 -> CoinsFragment()
//            DEFAULT
            else -> CoinsFragment()
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
