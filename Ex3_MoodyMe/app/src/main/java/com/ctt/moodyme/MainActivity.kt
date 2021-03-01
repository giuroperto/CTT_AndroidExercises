package com.ctt.moodyme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnStart : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart = findViewById(R.id.btnStart)

        btnStart.setOnClickListener{
            redirect()
        }
    }

    fun redirect() {

        val targetActivity = Intent(this, MoodActivity::class.java)

        startActivity(targetActivity)

    }
}