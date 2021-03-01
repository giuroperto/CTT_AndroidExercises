package com.ctt.pet4jokes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.net.toUri
import com.ctt.pet4jokes.model.Pet

class MainActivity : AppCompatActivity() {

    private lateinit var btnStart : Button
    lateinit var dogList: List<Pet>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart = findViewById(R.id.btnStart)

        val dog1 = Pet("Spaghetti", R.mipmap.ic_dog1_foreground)
        val dog2 = Pet("Porpetta", R.mipmap.ic_dog2_foreground)
        val dog3 = Pet("Ghiaccio", R.mipmap.ic_dog3_foreground)
        val dog4 = Pet("Troppo", R.mipmap.ic_dog4_foreground)
        val dog5 = Pet("Piccolino", R.mipmap.ic_dog5_foreground)
        val dog6 = Pet("Principessa", R.mipmap.ic_dog6_foreground)

        dogList = listOf(dog1, dog2, dog3, dog4, dog5, dog6)

        var rand = (Math.random() * 7).toInt() - 1

        var randomDog = dogList[rand]

        btnStart.setOnClickListener{
            redirect(randomDog)
        }
    }

    fun redirect(dog: Pet) {

        val dogKey = "DOG"

        val targetActivity = Intent(this, PetActivity::class.java)
        targetActivity.putExtra(dogKey, dog)

        startActivity(targetActivity)
    }
}


