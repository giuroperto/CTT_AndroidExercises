package com.ctt.whatsupp

import android.content.Context
import androidx.core.content.res.TypedArrayUtils.getText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(fm: FragmentManager, pageAdapterContext: Context) : FragmentPagerAdapter(fm) {

    var contextHere = pageAdapterContext

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
//            CONVERSAS
            0 -> ContatosFragment()
//            STATUS
            1 -> StatusFragment()
//            CHAMADAS
            2 -> CallsFragment()
            else -> ContatosFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> contextHere.getString(R.string.conversas)
            1 -> contextHere.getString(R.string.status)
            2 -> contextHere.getString(R.string.chamadas)
            else -> super.getPageTitle(position)
        }
    }
}
