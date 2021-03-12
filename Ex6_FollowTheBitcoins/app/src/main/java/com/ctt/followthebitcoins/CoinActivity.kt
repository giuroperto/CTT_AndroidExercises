package com.ctt.followthebitcoins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.ctt.followthebitcoins.model.Coin
import com.ctt.followthebitcoins.services.TickerService
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin)

        val tabLayout = findViewById<TabLayout>(R.id.tbMenu)
        val viewPager = findViewById<ViewPager>(R.id.vwTabs)

        viewPager.adapter = PageAdapter(supportFragmentManager, this)
        tabLayout.setupWithViewPager(viewPager)
    }

    companion object {

    }
}