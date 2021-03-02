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

        val dog1 = Pet("Spaghetti", "https://images.pexels.com/photos/2023384/pexels-photo-2023384.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
        val dog2 = Pet("Porpetta", "https://images.pexels.com/photos/1805164/pexels-photo-1805164.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
        val dog3 = Pet("Ghiaccio", "https://images.pexels.com/photos/1619690/pexels-photo-1619690.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
        val dog4 = Pet("Troppo", "https://images.pexels.com/photos/755380/pexels-photo-755380.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
        val dog5 = Pet("Piccolino", "https://images.pexels.com/photos/37401/dog-cute-pet.jpg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
        val dog6 = Pet("Principessa", "https://images.pexels.com/photos/1390361/pexels-photo-1390361.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")

        dogList = listOf(dog1, dog2, dog3, dog4, dog5, dog6)

        var rand = (Math.random() * 6).toInt()

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


