package com.ctt.pet4jokes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.ctt.pet4jokes.model.DogPicture
import com.ctt.pet4jokes.model.Pet
import com.ctt.pet4jokes.services.DogPicturesService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var btnStart : Button
    private lateinit var dogImg : String
    lateinit var dogList: List<Pet>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart = findViewById(R.id.btnStart)

//        val dog1 = Pet("Spaghetti", "https://images.pexels.com/photos/2023384/pexels-photo-2023384.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
//        val dog2 = Pet("Porpetta", "https://images.pexels.com/photos/1805164/pexels-photo-1805164.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
//        val dog3 = Pet("Ghiaccio", "https://images.pexels.com/photos/1619690/pexels-photo-1619690.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
//        val dog4 = Pet("Troppo", "https://images.pexels.com/photos/755380/pexels-photo-755380.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
//        val dog5 = Pet("Piccolino", "https://images.pexels.com/photos/37401/dog-cute-pet.jpg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
//        val dog6 = Pet("Principessa", "https://images.pexels.com/photos/1390361/pexels-photo-1390361.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")

//        integrating with dog pictures api

        val dog1 = Pet("Spaghetti")
        val dog2 = Pet("Porpetta")
        val dog3 = Pet("Ghiaccio")
        val dog4 = Pet("Troppo")
        val dog5 = Pet("Piccolino")
        val dog6 = Pet("Principessa")

        dogList = listOf(dog1, dog2, dog3, dog4, dog5, dog6)

        var rand = (Math.random() * 6).toInt()

        var randomDog = dogList[rand]

        getDogImage()

        btnStart.setOnClickListener{
            redirect(randomDog, dogImg)
        }
    }

    fun redirect(dog: Pet, dogImg: String) {

        val dogKey = "DOG"
        val dogImgKey = "DOGIMG"

        val targetActivity = Intent(this, PetActivity::class.java)
        targetActivity.putExtra(dogKey, dog)
        targetActivity.putExtra(dogImgKey, dogImg)

        startActivity(targetActivity)
    }

    fun getDogImage() {
        val retrofitClient = Network.RetrofitConfig("https://dog.ceo/api/")
        val service = retrofitClient.create(DogPicturesService::class.java)
        val call = service.getDogPicture()

        call.enqueue(
            object : Callback<DogPicture> {
                override fun onResponse(call: Call<DogPicture>, response: Response<DogPicture>) {
                    val dogImgResponse = response.body()?.pictureURL

                    dogImgResponse?.let{
                        if (it.isNotEmpty()) {
                            dogImg = dogImgResponse
                        } else {
                            dogImg = "https://images.dog.ceo/breeds/akita/An_Akita_Inu_resting.jpg"
                        }
                    }
                }

                override fun onFailure(call: Call<DogPicture>, t: Throwable) {
                    Log.e("APIERROR", "Something went wrong... Please try again!")
                }
            }
        )
    }
}


