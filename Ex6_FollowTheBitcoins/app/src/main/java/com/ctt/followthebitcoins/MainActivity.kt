package com.ctt.followthebitcoins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tbMenu)
        val viewPager = findViewById<ViewPager>(R.id.vwTabs)

        viewPager.adapter = PageAdapter(supportFragmentManager, this)
        tabLayout.setupWithViewPager(viewPager)
    }
}