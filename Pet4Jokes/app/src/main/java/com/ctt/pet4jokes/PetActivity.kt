package com.ctt.pet4jokes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class PetActivity : AppCompatActivity() {

    private lateinit var imgDog : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet)

        imgDog = findViewById(R.id.imgDog)

        var count = 0
        var rand = (Math.random() * (11)).toInt()

        imgDog.setOnClickListener() {
            if (count == rand) {
                redirect()
            } else {
                count += 1
            }
        }

    }

    fun redirect() {

        val targertActivity = Intent(this, JokeActivity::class.java)

        startActivity(targertActivity)
    }
}

// TODO: 28/02/2021 integrate pet pictures with API 